package View.Package;

import Controller.OrderController;
import Controller.PackageController;

import javax.swing.*;

public class PackageDashboard extends JPanel {
    private PackageController packageController;

    public PackageDashboard() {
        this.packageController = new PackageController(this);
    }


    public void getPackages() {
        packageController.getPackages();
    }
}
