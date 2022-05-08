package Controller;

import Config.errors.StringException;
import Model.PackageModel;
import Model.ProductModel;
import Model.entities.Package;
import Model.entities.Product;
import Utils.Helpers;
import View.Package.PackageDashboard;
import View.Package.PackageForm;
import View.Product.ProductDashboard;
import View.Product.ProductForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageController {

    private PackageModel packageModel = new PackageModel();
    private PackageForm form;
    private PackageDashboard dash;
    private JTable table;

    private List<Package> packages;

    public PackageController(PackageDashboard dash) {
        this.dash = dash;
    }

    public PackageController(PackageForm form) {
        this.form = form;
    }

    public void submitPackage(){
        // submit package

        String name = this.form.getNameText().getText().trim();
        int cost = Integer.valueOf(this.form.getCostText().getText().trim());

        try {
            this.packageModel.createPackage(name, cost);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getPackages(){
        try {
            this.packages = new ArrayList<Package>(this.packageModel.getPackages());
            table = Helpers.getPackageTableRows(packages);
            this.dash.add(table);
        } catch (SQLException | StringException ex) {
            ex.printStackTrace();
        }
    }
}
