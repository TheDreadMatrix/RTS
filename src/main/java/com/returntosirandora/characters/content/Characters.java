package com.returntosirandora.characters.content;

import com.returntosirandora.characters.defenition.CharacterDescription;
import com.returntosirandora.characters.enums.CharacterClass;
import com.returntosirandora.characters.enums.CharacterRarity;
import com.returntosirandora.characters.enums.CharacterType;
import com.returntosirandora.content.titles.Titles;
import com.returntosirandora.characters.defenition.CharacterAsset;

/*
Return to Sirandora characters

Character:
        name 
        description

        speed - current speed
        speedUp - speed with Key Shift
        stamina - stamina for running
        class - Which class for Character
        type - Who is it? Killer or Survival
        title - Title for battle card
        asset - sprites
        skins - skins for character

Killers: 
        1. Fred - common
        2. Xor, Trevor, Rayan - rare
        3. UltH, Redis, Nullean, Projectile - epic
        4. Algol, DreadMatrix - legendary


Survivals:
        1. Will - common
        2. Maven, Groovy - rare
        3. Summon, Lumi, Julian - epic
        4. OmniRest - legendary


Defenders:
        1. Hank - rare
        2. Deimos - rare
        3. Sylvestr - epic
        4. 


*/
public class Characters {
        // Killers
        public static final CharacterDescription FRED = new CharacterDescription.Builder()
                        .name("Fred")
                        .description("Fred")
                        .health(1000)
                        .speed(150)
                        .speedUp(230)
                        .stamina(120)
                        .characterClass(CharacterClass.ASSASIN)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.COMMON)
                        .title(Titles.TILTE_FRED_0)
                        .skins(CharacterSkins.FRED_SKIN_0)
                        .asset(new CharacterAsset("atlas/killers/fred/", "portrait/killers/fred/"))
                        .build();

        public static final CharacterDescription RAYAN = new CharacterDescription.Builder()
                        .name("Rayan")
                        .description("Rayan")
                        .speed(150)
                        .speed(250)
                        .stamina(150)
                        .characterClass(CharacterClass.ASSASIN)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.RARE)
                        .title(Titles.TITLE_RAYAN_0)
                        .build();

        public static final CharacterDescription TREVOR = new CharacterDescription.Builder()
                        .name("Trevor")
                        .description("Asm")
                        .speed(130)
                        .speedUp(200)
                        .stamina(100)
                        .characterClass(CharacterClass.HYBRID)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.RARE)
                        .title(Titles.TITLE_TREVOR_0)
                        .build();

        public static final CharacterDescription XOR = new CharacterDescription.Builder()
                        .name("Xor")
                        .description("Xor")
                        .speed(150)
                        .speedUp(200)
                        .stamina(150)
                        .characterClass(CharacterClass.CONTROLLER)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.RARE)
                        .title(Titles.TITLE_XOR_0)
                        .build();

        public static final CharacterDescription NULLEAN = new CharacterDescription.Builder()
                        .name("Nullean")
                        .description("Nullean")
                        .health(1700)
                        .speed(120)
                        .speedUp(160)
                        .stamina(80)
                        .characterClass(CharacterClass.TANK)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_NULLEAN_0)
                        .build();

        public static final CharacterDescription REDIS = new CharacterDescription.Builder()
                        .name("Redis")
                        .description("Redis")
                        .health(800)
                        .speed(200)
                        .speedUp(300)
                        .stamina(200)
                        .characterClass(CharacterClass.ASSASIN)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_REDIS_0)
                        .build();

        public static final CharacterDescription ULTH = new CharacterDescription.Builder()
                        .name("UltH")
                        .description("UltH")
                        .health(1500)
                        .speed(150)
                        .speedUp(180)
                        .stamina(80)
                        .characterClass(CharacterClass.MARKSMAN)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_ULTH_0)
                        .build();

        public static final CharacterDescription PROJECTILE = new CharacterDescription.Builder()
                        .name("Projectile")
                        .description("Projectile")
                        .health(1500)
                        .speed(170)
                        .speedUp(200)
                        .stamina(150)
                        .characterClass(CharacterClass.CONTROLLER)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_PROJECTILE_0)
                        .build();

        public static final CharacterDescription DREAD_MATRIX = new CharacterDescription.Builder()
                        .name("The Dread Matrix")
                        .description("DreadMatrix")
                        .health(1200)
                        .speed(170)
                        .speedUp(230)
                        .stamina(120)
                        .characterClass(CharacterClass.HYBRID)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.LEGENDARY)
                        .title(Titles.TITLE_DREAD_MATRIX_0)
                        .skins(CharacterSkins.DREAD_MATRIX_SKINS)
                        .build();

        public static final CharacterDescription ALGOL = new CharacterDescription.Builder()
                        .name("Algol")
                        .description("Algol")
                        .health(2000)
                        .speed(95)
                        .speedUp(110)
                        .stamina(150)
                        .characterClass(CharacterClass.TANK)
                        .characterType(CharacterType.KILLER)
                        .rarity(CharacterRarity.LEGENDARY)
                        .title(Titles.TITLE_ALGOL_0)
                        .build();

        // Survivals
        public static final CharacterDescription WILL = new CharacterDescription.Builder()
                        .name("Will")
                        .description("Will")
                        .health(700)
                        .speed(130)
                        .speedUp(170)
                        .stamina(200)
                        .characterClass(CharacterClass.CONTROLLER)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.COMMON)
                        .title(Titles.TITLE_WILL_0)
                        .build();

        public static final CharacterDescription MAVEN = new CharacterDescription.Builder()
                        .name("Maven")
                        .description("Maven")
                        .health(500)
                        .speed(135)
                        .speedUp(175)
                        .stamina(170)
                        .characterClass(CharacterClass.CONTROLLER)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.RARE)
                        .title(Titles.TITLE_MAVEN_0)
                        .build();

        public static final CharacterDescription GROOVY = new CharacterDescription.Builder()
                        .name("Groovy")
                        .description("Groovy")
                        .health(900)
                        .speed(100)
                        .speedUp(150)
                        .stamina(50)
                        .characterClass(CharacterClass.TANK)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.RARE)
                        .title(Titles.TITLE_GROOVY_0)
                        .build();

        public static final CharacterDescription SUMMON = new CharacterDescription.Builder()
                        .name("Summon")
                        .description("Summon")
                        .health(750)
                        .speed(130)
                        .speedUp(170)
                        .stamina(80)
                        .characterClass(CharacterClass.SUMMONER)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_SUMMON_0)
                        .build();

        public static final CharacterDescription LUMI = new CharacterDescription.Builder()
                        .name("Lumi")
                        .description("Lumi")
                        .health(450)
                        .speed(140)
                        .speedUp(180)
                        .stamina(120)
                        .characterClass(CharacterClass.HEALER)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_LUMI_0)
                        .build();

        public static final CharacterDescription JULIAN = new CharacterDescription.Builder()
                        .name("Julian")
                        .description("Julian")
                        .health(780)
                        .speed(170)
                        .speedUp(210)
                        .stamina(180)
                        .characterClass(CharacterClass.HYBRID)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_JULIAN_0)
                        .build();

        public static final CharacterDescription OMNI_REST = new CharacterDescription.Builder()
                        .name("Omni Rest")
                        .description("Omni Rest")
                        .health(1500)
                        .speed(100)
                        .speedUp(150)
                        .stamina(30)
                        .characterClass(CharacterClass.TANK)
                        .characterType(CharacterType.SURVIVAL)
                        .rarity(CharacterRarity.LEGENDARY)
                        .title(Titles.TITLE_OMNI_REST_0)
                        .build();

        // Defenders
        public static final CharacterDescription HANK = new CharacterDescription.Builder()
                        .name("Hank")
                        .description("Hank")
                        .health(2000)
                        .speed(120)
                        .speedUp(150)
                        .stamina(150)
                        .characterClass(CharacterClass.TANK)
                        .characterType(CharacterType.DEFENDER)
                        .rarity(CharacterRarity.COMMON)
                        .title(Titles.TITLE_HANK_0)
                        .build();

        public static final CharacterDescription DEIMOS = new CharacterDescription.Builder()
                        .name("Deimos")
                        .description("Deimos")
                        .health(1800)
                        .speed(150)
                        .speedUp(190)
                        .stamina(150)
                        .characterClass(CharacterClass.MARKSMAN)
                        .characterType(CharacterType.DEFENDER)
                        .rarity(CharacterRarity.RARE)
                        .title(Titles.TITLE_DEIMOS_0)
                        .build();

        public static final CharacterDescription SYLVESTR = new CharacterDescription.Builder()
                        .name("Sylvestr")
                        .description("Sylvestr")
                        .health(2500)
                        .speed(130)
                        .speedUp(165)
                        .stamina(150)
                        .characterClass(CharacterClass.TANK)
                        .characterType(CharacterType.DEFENDER)
                        .rarity(CharacterRarity.EPIC)
                        .title(Titles.TITLE_SYLVESTR_0)
                        .build();
}
