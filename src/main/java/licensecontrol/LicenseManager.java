package licensecontrol;

public class LicenseManager {
    public static Boolean check_activation(ActivationData activation_data, LicenseData license_data) {
        if (license_data.type == LicenseData.Type.HARDWARE_NOCHECK) {
            if (activation_data.date.after(license_data.maximum_activation_date))
                return false;

            return true;
        }
        else if ((license_data.type == LicenseData.Type.HARDWARE_CHECK)) {
            if (activation_data.date.after(license_data.maximum_activation_date))
                return false;

            if (license_data.activations.size() == license_data.maximum_number_of_activations) {
                if (!license_data.activations.contains(activation_data.hardware_id))
                    return false;
            }

            return true;
        }

        return false;
    }
}
