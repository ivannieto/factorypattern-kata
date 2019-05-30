package licensecontrol;

public class LicenseManagerFactory {
    public enum Type {
        HARDWARE_CHECK, HARDWARE_NOCHECK
    }
       
    public static ILicenseManager create(LicenseData.Type type) throws Exception {
        if (type.equals(LicenseData.Type.HARDWARE_CHECK))
            return new HardwareCheck();
        else if (type.equals(LicenseData.Type.HARDWARE_NOCHECK))
            return new HardwareNoCheck();
        else
            throw new Exception("Not implemented type");
            
    }
}