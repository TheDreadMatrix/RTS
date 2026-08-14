package com.returntosirandora.characters.content;

import java.util.List;

import com.returntosirandora.characters.CharacterSkin;
import com.returntosirandora.characters.CharacterSkin.SkinCategory;

public class CharacterSkins {

    public static final CharacterSkin FRED_SKIN_0 = new CharacterSkin.Builder()
            .name("Sand Man Fred")
            .cost(500)
            .categories(List.of(SkinCategory.COMMON))
            .build();
}
