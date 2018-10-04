package csekosys.sum;

public class Constants {

    public static final String SD_PATH = "storage/sdcard1/";
    public static final String LOGS_PATH = "storage/sdcard1/logs/";
    public static final String AEEAPP_PATH = "data/data/com.tekinvest.aeeapp/";
    public static final String APP_CERT_PATH = "data/data/com.tekinvest.aeeapp/app_cert/";
    public static final String APP_CONFIG_PATH = "data/data/com.tekinvest.aeeapp/app_config/";
    public static final String AEEAPP_SHARED_PREFS_PATH = "data/data/com.tekinvest.aeeapp/shared_prefs/";
    public static final String CASHREG_SHARED_PREFS_PATH = "data/data/com.tekinvest.novatek.cashregister/shared_prefs/";
    public static final String TPM_PATH = "data/tpm/";
    public static final String TPM_USER_PATH = "data/tpm-user/";
    public static final String TEKI_PATH = "data/teki/";

    public static String[][] systemFiles = new String[][]{
        {TPM_PATH, "system.data"},
        {TPM_USER_PATH, "user.data"},
        {TEKI_PATH, "version.xml"},
        {TEKI_PATH, "type.xml"},
        {APP_CERT_PATH, "NAVCertKey.exp"},
        {APP_CERT_PATH, "NAVCertKey.mod"},
        {APP_CERT_PATH, "NAVCertKey.pub"},
        {APP_CERT_PATH, "nav.cer"},
        {APP_CERT_PATH, "navAuth.cer"},
        {APP_CERT_PATH, "navAuth.prv"},
        {APP_CONFIG_PATH, "ActionsAfterClose.dat"},
        {APP_CONFIG_PATH, "BaseInfo.dat_t"},
        {APP_CONFIG_PATH, "BlockCauses.dat_t"},
        {APP_CONFIG_PATH, "CashRegisterType.dat"},
        {APP_CONFIG_PATH, "ConclusionDate.dat"},
        {APP_CONFIG_PATH, "Config.dat"},
        {APP_CONFIG_PATH, "ErrorCodes.dat"},
        {APP_CONFIG_PATH, "EuroRate.dat"},
        {APP_CONFIG_PATH, "EuroSwitchDate.dat"},
        {APP_CONFIG_PATH, "HeaderLines.dat"},
        {APP_CONFIG_PATH, "HeaderPrintCommands.dat"},
        {APP_CONFIG_PATH, "LastCloseDate.dat"},
        {APP_CONFIG_PATH, "LastOpeningDate.dat"},
        {APP_CONFIG_PATH, "LastReviewDate.dat"},
        {APP_CONFIG_PATH, "PendingNavMessages.dat"},
        {APP_CONFIG_PATH, "PersistedScheduledEvents.dat"},
        {APP_CONFIG_PATH, "PreparationDate.dat"},
        {APP_CONFIG_PATH, "PreviousRegistrationSessionToken.dat"},
        {APP_CONFIG_PATH, "RegistrationDate.dat"},
        {APP_CONFIG_PATH, "SiteInfo.dat"},
        {AEEAPP_SHARED_PREFS_PATH, "repository.xml"},
        {CASHREG_SHARED_PREFS_PATH, "com.tekinvest.novatek.cashregister_preferences.xml"},
        {SD_PATH, "cashreg.db"},
        {SD_PATH, "cashregister.db"}
    };
}
