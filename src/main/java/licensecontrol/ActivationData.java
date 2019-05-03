package licensecontrol;

import java.util.Date;

public class ActivationData {
    public Date date;
    public String hardware_id;

    public ActivationData(Date date, String hardware_id) {
        this.date = date;
        this.hardware_id = hardware_id;
    }
}
