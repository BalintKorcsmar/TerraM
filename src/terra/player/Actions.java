package terra.player;

import terra.unit.BuildingType;

public interface Actions {
    public void TransformAndBuild(int x, int y);

    public void AdvanceOnShippingTrack();

    public void UpgradeSpades();
//
    public void UpgradeStructure(int x, int y, BuildingType building);
//
//    public void SendPriestToOrderOfCult(String color);
//
//    public void PerformPowerAction();
//
//    public void PerformSpecialAction();
//
//    public void Pass();
}
