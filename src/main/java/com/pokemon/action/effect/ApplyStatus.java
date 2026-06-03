package com.pokemon.action.effect;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;
import com.pokemon.pokemon.status.StatusInterface;

import java.util.function.Supplier;

public class ApplyStatus implements MoveEffectInterface {

    private final TargetInterface target;
    private final Supplier<StatusInterface> factory;
    private final String appliedMessage;

    public ApplyStatus(TargetInterface target, Supplier<StatusInterface> factory, String appliedMessage) {
        this.target         = target;
        this.factory        = factory;
        this.appliedMessage = appliedMessage;
    }

    @Override
    public void apply(Battle battle) {
        Pokemon p = target.resolve(battle).getActivePokemon();
        StatusInterface status = factory.get();
        String statusName = status.getClass().getSimpleName().replace("Status", "");

        if (Battle.DEV_MODE) {
            battle.log("[DEV] Trying to apply " + statusName + " to " + p.getNickname(),
                    Battle.LogCategory.DEV);
        }

        if (p.hasStatusOfType(status.getClass())) {
            if (Battle.DEV_MODE) {
                battle.log("[DEV] → Rejected: " + p.getNickname() + " already has " + statusName,
                        Battle.LogCategory.DEV);
            }
            return;
        }

        if (status.isPrimary() && p.hasAnyPrimaryStatus()) {
            if (Battle.DEV_MODE) {
                String existing = p.getStatusList().stream()
                        .filter(StatusInterface::isPrimary)
                        .map(s -> s.getClass().getSimpleName().replace("Status", ""))
                        .findFirst().orElse("unknown");
                battle.log("[DEV] → Rejected: " + p.getNickname()
                        + " already has primary status " + existing
                        + " — can't apply " + statusName,
                        Battle.LogCategory.DEV);
            }
            return;
        }

        p.addStatus(status);
        battle.log(appliedMessage.replace("{name}", p.getNickname()), Battle.LogCategory.STATUS);
    }
}