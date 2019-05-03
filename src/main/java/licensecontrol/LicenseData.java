package licensecontrol;

import java.util.Date;
import java.util.List;

public class LicenseData {
    public enum Type {
        HARDWARE_CHECK,
        HARDWARE_NOCHECK
    }

    public Type type;
    public Date maximum_activation_date;
    public Integer maximum_number_of_activations;
    public List<String> activations;

    public LicenseData(Type type, Date maximum_activation_date, Integer maximum_number_of_activations, List<String> activations) {
        this.type = type;
        this.maximum_activation_date = maximum_activation_date;
        this.maximum_number_of_activations = maximum_number_of_activations;
        this.activations = activations;
    }

}
