import pygame as pg


class Block:
    def __init__(self, x, y, width=64, height=64):
        self.rect = pg.Rect(x, y, width, height)
        self.color = (80, 120, 80)

    def draw(self, screen):
        pg.draw.rect(screen, self.color, self.rect)


class Player:
    def __init__(self, x, y, width=40, height=56):
        self.rect = pg.Rect(x, y, width, height)
        self.speed = 250
        self.color = (220, 80, 80)

    def update(self, dt, blocks):
        dx = 0
        dy = 0

        if pg.key.get_pressed()[pg.K_w]:
            dy -= self.speed * dt

        if pg.key.get_pressed()[pg.K_s]:
            dy += self.speed * dt

        if pg.key.get_pressed()[pg.K_a]:
            dx -= self.speed * dt

        if pg.key.get_pressed()[pg.K_d]:
            dx += self.speed * dt

        # X
        self.rect.x += dx

        

        # Y
        self.rect.y += dy

     

    def draw(self, screen):
        pg.draw.rect(screen, self.color, self.rect)


pg.init()

screen = pg.display.set_mode((800, 600))
clock = pg.time.Clock()

player = Player(350, 300)

blocks = [
    Block(300, 200),
    Block(400, 200),
    Block(350, 350),
]
objects = blocks + [player]
running = True

while running:
    dt = clock.tick(60) / 1000.0

    for event in pg.event.get():
        if event.type == pg.QUIT:
            running = False

    player.update(dt, blocks)

    screen.fill((30, 30, 30))

    # Все объекты, которые участвуют в depth sorting
    

    # Чем ниже объект находится, тем позже он рисуется
    objects.sort(key=lambda obj: obj.rect.bottom)

    for obj in objects:
        obj.draw(screen)

    pg.display.flip()

pg.quit()