package prog07_tarea;

/**
 * CLASE Banco realiza todos los métodos necesarios para proporcionar la
 * funcionalidad en el programa
 */
public class Banco {
    //private CuentaBancaria cuentaBancaria;

    final int MAX_CUENTAS_BANCARIAS = 100;
    /**
     * siguiendo la estructura de herencia, CuentaBancaria es la clase padre del
     * resto de Cuentas por lo tanto mediante un array de esta Clase mantengo la
     * estructura de herencia de esta Clase
     */
    CuentaBancaria[] cuentasBancarias;
    int numCuentas;

    /**
     * CONSTRUCTOR
     */
    public Banco() {
        this.cuentasBancarias = new CuentaBancaria[MAX_CUENTAS_BANCARIAS];
        this.numCuentas = 0;
    }

    /**
     * METODO inserta una CuentaBancaria en el array cuentasBancarias
     */
    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        try {
            this.cuentasBancarias[this.numCuentas] = cuentaBancaria;
            this.numCuentas++;
            return true;
        } catch (Exception e) {
            System.err.println("Se ha producido un error al abrir la Cuenta |Error: " + e);
        }
        return false;
    }

    /**
     * METODO lista Info de cada CuentaBancaria existente en el array
     * cuentasBancarias
     */
    public String[] listadoCuentas() {
        String[] devuelve = new String[this.numCuentas];
        try {
            for (int i = 0; i < this.numCuentas; i++) {
                devuelve[i] = this.cuentasBancarias[i].devolverInfoString();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al listar las Cuentas |Error: " + e);
        }
        return devuelve;
    }

    /**
     * METODO devuelve Info de la CuentaBancaria que se pasa por parámetro
     * verificando su existencia en el array cuentasBancarias
     */
    public String informacionCuenta(String iban) {
        String devuelve = null;
        try {
            for (int i = 0; i < this.numCuentas; i++) {
                if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                    devuelve = this.cuentasBancarias[i].devolverInfoString();
                    break;
                }
                devuelve = "No existe Cuenta con ese número de IBAN";
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al informar de la Cuenta |Error: " + e);
        }
        return devuelve;
    }

    /**
     * METODO ingresa dinero en cuenta que se pasa por parámetro verificando su
     * existencia en el array cuentasBancarias
     */
    public boolean ingresoCuenta(String iban, double ingreso) {
        try {
            for (int i = 0; i < this.numCuentas; i++) {
                if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                    double saldo = cuentasBancarias[i].getSaldo() + ingreso;
                    this.cuentasBancarias[i].setSaldo(saldo);
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al ingresar la cantidad en la Cuenta |Error: " + e);
        }
        return false;
    }

    /**
     * METODO retira dinero de cuenta que se pasa por parámetro verificando su
     * existencia en el array cuentasBancarias
     */
    public boolean retiradaCuenta(String iban, double cantidad) {
        try {
            for (int i = 0; i < this.numCuentas; i++) {
                if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                    double saldo = cuentasBancarias[i].getSaldo();
                    if (saldo < cantidad) {
                        System.out.println("No tiene suficiente dinero en Cuenta");
                        return false;
                    } else {
                        saldo -= cantidad;
                        this.cuentasBancarias[i].setSaldo(saldo);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al retirar la cantidad en la Cuenta |Error: " + e);
        }
        return false;
    }

    /**
     * METODO devuelve el saldo de una cuenta que se pasa por parámetro
     * verificando su existencia en el array cuentasBancarias
     */
    public double obtenerSaldo(String iban) {
        try {
            for (int i = 0; i < this.numCuentas; i++) {
                if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                    return this.cuentasBancarias[i].getSaldo();
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al obtener el saldo de la Cuenta |Error: " + e);
        }
        return -1;
    }

}