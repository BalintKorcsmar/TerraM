package terra.player;

import terra.player.factions.Aclhemists;
import terra.player.factions.Auren;
import terra.player.factions.ChaosMagician;
import terra.player.factions.Cultists;
import terra.player.factions.Darklings;
import terra.player.factions.Dwarves;
import terra.player.factions.Engineers;
import terra.player.factions.Fakirs;
import terra.player.factions.Giants;
import terra.player.factions.Halflings;
import terra.player.factions.Mermaids;
import terra.player.factions.Nomads;
import terra.player.factions.Swarmlings;
import terra.player.factions.Witches;

public enum FactionTypes {
    AUREN, WITCHES, ALCHEMISTS, DARKLINGS, HALFLINGS, CULTISTS, ENGINEERS, DWARVES,
    MERMAIDS, SWARMLINGS, CHAOS_MAGICIANS, GIANTS, FAKIRS, NOMADS;

    public static FactionTypes getFactionType(int num, boolean type) {
        switch(num) {
        case 0:
            if(type) {
                return AUREN;
            }
            return WITCHES;
        case 1:
            if(type) {
                return ALCHEMISTS;
            }
            return DARKLINGS;
        case 2:
            if(type) {
                return HALFLINGS;
            }
            return CULTISTS;
        case 3:
            if(type) {
                return ENGINEERS;
            }
            return DWARVES;
        case 4:
            if(type) {
                return MERMAIDS;
            }
            return SWARMLINGS;
        case 5:
            if(type) {
                return CHAOS_MAGICIANS;
            }
            return GIANTS;
        case 6:
            if(type) {
                return FAKIRS;
            }
            return NOMADS;
        default:
            return null;
        }
    }
    
    public Player getPlayer(FactionTypes type) {
        switch(this) {
        case ALCHEMISTS:
            return Aclhemists.getInstance();
        case AUREN:
            return Auren.getInstance();
        case CHAOS_MAGICIANS:
            return ChaosMagician.getInstance();
        case CULTISTS:
            return Cultists.getInstance();
        case DARKLINGS:
            return Darklings.getInstance();
        case DWARVES:
            return Dwarves.getInstance();
        case ENGINEERS:
            return Engineers.getInstance();
        case FAKIRS:
            return Fakirs.getInstance();
        case GIANTS:
            return Giants.getInstance();
        case HALFLINGS:
            return Halflings.getInstance();
        case MERMAIDS:
            return Mermaids.getInstance();
        case NOMADS:
            return Nomads.getInstance();
        case SWARMLINGS:
            return Swarmlings.getInstance();
        case WITCHES:
            return Witches.getInstance();
        default:
            return null;
        }
    }
    
    public String getColor(FactionTypes type) {
        switch(this) {
        case ALCHEMISTS:
        case DARKLINGS:
            return "BLACK";
        case AUREN:
        case WITCHES:
            return "GREEN";
        case CHAOS_MAGICIANS:
        case GIANTS:
            return "RED";
        case CULTISTS:
        case HALFLINGS:
            return "BROWN";
        case DWARVES:
        case ENGINEERS:
            return "GREY";
        case FAKIRS:
        case NOMADS:
            return "YELLOW";
        case SWARMLINGS:
        case MERMAIDS:
            return "BLUE";
        default:
            return null;
        }
    }
}
