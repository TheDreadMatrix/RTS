package com.returntosirandora.characters.logic.abilities;

import com.returntosirandora.characters.defenition.AbilityDescriptior;

public class BaseAbility {
    protected float coolDown;

    public BaseAbility(AbilityDescriptior abilityDesc) {
        this.coolDown = abilityDesc.getCoolDown();

    }

}
