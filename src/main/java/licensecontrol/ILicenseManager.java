package licensecontrol;

public interface ILicenseManager {
    public Boolean check_activation(ActivationData activation_data, LicenseData license_data);
}