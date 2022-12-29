package dummiescertificationauthority;

import data.Nif;
import data.Password;
import data.SmallCode;
import publicadministration.Citizen;
import services.CertificationAuthorityInterface;
import services.exceptions.*;

import java.util.Date;

public class ClavePINCertificationAuthority implements CertificationAuthorityInterface {

    Citizen citizen;

    public ClavePINCertificationAuthority(Citizen citizen) {
        this.citizen = citizen;
    }

    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, NotValidCredException {

        if (!nif.equals(citizen.getNif())) {
            throw new NifNotRegisteredException("El NIF no está registrado.");
        }
        if (!date.equals(citizen.getValDate())) {
            throw new NotValidCredException("La contraseña no es correcta.");
        }
        if (citizen.getMobileNumb() == null) {
            throw new AnyMobileRegisteredException("No hay ningún número de móvil registrado.");
        }
        return true;

    }

    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException {
        if (!pin.equals(citizen.getPIN()))
            throw new NotValidPINException("PIN incorrecte");

        return true;
    }

    public byte checkCredent(Nif nif, Password passw) throws NifNotRegisteredException, NotValidCredException, AnyMobileRegisteredException, ConnectException {
        return 0;
    }

}