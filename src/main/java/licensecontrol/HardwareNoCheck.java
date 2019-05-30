package licensecontrol;

public class HardwareNoCheck implements ILicenseManager {

    public Boolean check_activation(ActivationData activation_data, LicenseData license_data) {
        return !activation_data.date.after(license_data.maximum_activation_date);
    }
}