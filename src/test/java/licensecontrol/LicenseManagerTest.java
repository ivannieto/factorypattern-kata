package licensecontrol;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LicenseManagerTest {
    public List<String> hardware_id_list = new ArrayList<String>(Arrays.asList("4D:DD:4E:44:B3:D3", "58:D9:A5:D5:5A:6F", "CD:7B:A6:CC:D7:54"));

    @org.junit.Test
    public void check_activation_returns_true_with_no_hardware_check_and_not_expired() {
        LicenseData license_data = new LicenseData(
                LicenseData.Type.HARDWARE_NOCHECK,
                new Date(2019,12,31),
                0,
                hardware_id_list);
        ActivationData activation_data = new ActivationData(new Date(2019,5,24),"71:32:82:AE:2C:C6");

        Boolean result = LicenseManager.check_activation(activation_data, license_data);

        Assert.assertTrue(result);
    }

    @org.junit.Test
    public void check_activation_returns_false_with_no_hardware_check_and_expired() {
        LicenseData license_data = new LicenseData(
                LicenseData.Type.HARDWARE_NOCHECK,
                new Date(2019,4,31),
                0,
                hardware_id_list);
        ActivationData activation_data = new ActivationData(new Date(2019,5,24),"71:32:82:AE:2C:C6");

        Boolean result = LicenseManager.check_activation(activation_data, license_data);

        Assert.assertFalse(result);
    }

    @org.junit.Test
    public void check_activation_returns_true_with_hardware_check() {
        LicenseData license_data = new LicenseData(
                LicenseData.Type.HARDWARE_CHECK,
                new Date(2019,12,31),
                10,
                hardware_id_list);
        ActivationData activation_data = new ActivationData(new Date(2019,5,24),"71:32:82:AE:2C:C6");

        Boolean result = LicenseManager.check_activation(activation_data, license_data);

        Assert.assertTrue(result);
    }

    @org.junit.Test
    public void check_activation_returns_false_with_hardware_check_and_expired() {
        LicenseData license_data = new LicenseData(
                LicenseData.Type.HARDWARE_CHECK,
                new Date(2019,4,31),
                10,
                hardware_id_list);
        ActivationData activation_data = new ActivationData(new Date(2019,5,24),"71:32:82:AE:2C:C6");

        Boolean result = LicenseManager.check_activation(activation_data, license_data);

        Assert.assertFalse(result);
    }

    @org.junit.Test
    public void check_activation_returns_false_with_hardware_check_and_maximum_activations_reached() {
        LicenseData license_data = new LicenseData(
                LicenseData.Type.HARDWARE_CHECK,
                new Date(2019,12,31),
                3,
                hardware_id_list);
        ActivationData activation_data = new ActivationData(new Date(2019,5,24),"71:32:82:AE:2C:C6");

        Boolean result = LicenseManager.check_activation(activation_data, license_data);

        Assert.assertFalse(result);
    }

    @org.junit.Test
    public void check_activation_returns_true_with_hardware_check_and_maximum_activations_reached_but_already_active() {
        LicenseData license_data = new LicenseData(
                LicenseData.Type.HARDWARE_CHECK,
                new Date(2019,12,31),
                3,
                hardware_id_list);
        ActivationData activation_data = new ActivationData(new Date(2019,5,24),"4D:DD:4E:44:B3:D3");

        Boolean result = LicenseManager.check_activation(activation_data, license_data);

        Assert.assertTrue(result);
    }


}