package licensecontrol;

public class LicenseManager {
    public static Boolean check_activation(ActivationData activation_data, LicenseData license_data) {
        try {
            ILicenseManager licenseManager = LicenseManagerFactory.create(license_data.type);
            return licenseManager.check_activation(activation_data, license_data);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
