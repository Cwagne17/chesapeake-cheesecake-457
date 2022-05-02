package Model.interfaces;

import Model.dto.CreatePackageDto;
import Model.dto.UpdatePackageDto;

import java.util.ArrayList;

public interface IPackageModel {

    public ArrayList<Package> getPackages();

    public void createPackage(CreatePackageDto createPackageDto);

    public void updatePackage(UpdatePackageDto updatePackageDto);

}
