package models.comisionStrategies;

public class BancoExterno implements ComisionStrategy {
    @Override
    public double calcularComision(double monto) {
        return monto * 0.05; // Comisión del 5%
    }
    
}
