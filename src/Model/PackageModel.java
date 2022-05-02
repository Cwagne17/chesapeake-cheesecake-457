package Model;

import Model.dto.CreatePackageDto;
import Model.dto.UpdatePackageDto;
import Model.interfaces.IPackageModel;

import java.util.ArrayList;

public class PackageModel implements IPackageModel {
    @Override
    public ArrayList<Package> getPackages() {
        return null;
    }

    @Override
    public void createPackage(CreatePackageDto createPackageDto) {

    }

    @Override
    public void updatePackage(UpdatePackageDto updatePackageDto) {

    }
}
