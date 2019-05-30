package licensecontrol;

public class HardwareCheck implements ILicenseManager {

    public Boolean check_activation(ActivationData activation_data, LicenseData license_data) {
        if (activation_data.date.after(license_data.maximum_activation_date))
            return false;

        if (license_data.activations.size() == license_data.maximum_number_of_activations) {
            return license_data.activations.contains(activation_data.hardware_id);
        }
        return true;
    }
}