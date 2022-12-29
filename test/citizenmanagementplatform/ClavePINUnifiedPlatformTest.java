package citizenmanagementplatform;

import citizenmanagementplatform.exceptions.IncompleteFormException;
import data.Nif;
import dummiescertificationauthority.ClavePINCertificationAuthority;
import exceptions.WrongNifFormatException;
import exceptions.WrongPasswordFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.exceptions.WrongMobileFormatException;
import services.exceptions.ConnectException;
import services.exceptions.IncorrectVerificationException;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClavePINUnifiedPlatformTest {

    Citizen citz;

    @BeforeEach
    public void setUp() throws WrongMobileFormatException, WrongNifFormatException, IncompleteFormException, IncorrectVerificationException, ConnectException {

        citz = new Citizen("Jake Peralta", "Calle Hispanidad 12", "612101210");
        citz.setNif(new Nif("99571829E"));

        UnifiedPlatform platform = new UnifiedPlatform();

        //citz.setValidationDate(LocalDate.of(1987, 1, 1));
        //citz.setValidationDate(LocalDate.now());

        Calendar cal = Calendar.getInstance();
        cal.set(1987, Calendar.MARCH, 24);

        citz.setValidationDate(LocalDate.now());
        platform.setAuthenticationMethod(new ClavePINCertificationAuthority(citz));
    }

}
