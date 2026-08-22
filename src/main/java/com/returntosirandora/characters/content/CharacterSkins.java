package com.returntosirandora.characters.content;

import java.util.List;

import com.returntosirandora.characters.defenition.CharacterSkinDescription;
import com.returntosirandora.characters.enums.SkinCategory;
import com.returntosirandora.characters.defenition.CharacterAsset.SkinAsset;

public class CharacterSkins {

        public static final CharacterSkinDescription FRED_SKIN_0 = new CharacterSkinDescription.Builder()
                        .name("Sand Man Fred")
                        .cost(500)
                        .categories(List.of(SkinCategory.COMMON))
                        .assets(new SkinAsset("atlas/skins/killers/sand-man-fred/"))
                        .build();

        private static final CharacterSkinDescription DREAD_MATRIX_SKIN_0 = new CharacterSkinDescription.Builder()
                        .name("Molten Star")
                        .cost(700)
                        .categories(List.of(SkinCategory.COMMON))
                        .assets(new SkinAsset("atlas/skins/killers/dread-matrix-molten-star/"))
                        .build();

        private static final CharacterSkinDescription DREAD_MATRIX_SKIN_1 = new CharacterSkinDescription.Builder()
                        .name("Vertex")
                        .cost(2500)
                        .categories(List.of(SkinCategory.EPIC))
                        .assets(new SkinAsset("atlas/skins/killers/dread-matrix-vertex/"))
                        .build();

        public static final List<CharacterSkinDescription> DREAD_MATRIX_SKINS = List.of(
                        DREAD_MATRIX_SKIN_0,
                        DREAD_MATRIX_SKIN_1);

}
