package models.comisionStrategies;

public class BancoLocal implements ComisionStrategy {
    @Override
    public double calcularComision(double monto) {
        return monto * 0.02; // Comisión del 2%
    }
    
}
