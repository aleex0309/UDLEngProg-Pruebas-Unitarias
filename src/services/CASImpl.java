package services;

import services.exceptions.NotValidPaymentDataException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CASImpl implements CAS{

    @Override
    public void askForApproval(String nTrans, String cardData, String date, BigDecimal imp) throws NotValidPaymentDataException {
        System.out.println("\033[32mVerificando los datos de la tarjeta de crédito...\033[0m");
        //Make a pause to simulate the verification process
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Set the date in format dd/MM/yyyy as LocalDate
        String[] dateParts = date.split("/");
        LocalDate expDate = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
        if (expDate.isBefore(LocalDate.now())) {
            throw new NotValidPaymentDataException("La tarjeta de crédito ha caducado");
        }
        System.out.println("\033[32mTransacción "+ nTrans + " en curso...\033[0m");
        LocalDate today = LocalDate.now();
        carryTrans(cardData,today,imp);
    }

    private void carryTrans(String cardData, LocalDate date, BigDecimal imp) {
        System.out.println("\033[32mRealizando la transacción...\033[0m");
        //Make a pause to simulate the verification process
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("____________________________________________");
        //Imprime el recibo con los datos de la transacción
        System.out.println("\033[32mRecibo de la transacción:\033[0m");
        System.out.println("Fecha: " + date);
        System.out.println("Número de tarjeta: " + cardData);
        System.out.println("Importe de la transacción: " + imp);
        System.out.println("____________________________________________");
    }
}
