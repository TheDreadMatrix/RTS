import socket
import time
import random


server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(("0.0.0.0", 8080))
server.listen(10)

LATENCY = 0.5          # 500 ms задержки
TIMEOUT_CHANCE = 0.1

while True:
    client, address = server.accept()

    print("Connection:", address)

    # Эмуляция плохой сети
    time.sleep(LATENCY)

    if random.random() < TIMEOUT_CHANCE:
        print("Simulating timeout...")
        time.sleep(10)
        client.close()
        continue

    data = client.recv(4096)

    print(data.decode())   

    body = '{"status":"ok"}'

    response = (
        "HTTP/1.1 200 OK\r\n"
        "Content-Type: application/json\r\n"
        f"Content-Length: {len(body.encode())}\r\n"
        "Connection: close\r\n"
        "\r\n"
        + body
    )

    client.sendall(response.encode())
    client.close()