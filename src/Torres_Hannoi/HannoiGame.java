package Torres_Hannoi;

public class HannoiGame {

    private TowerList torre1 = new TowerList();
    private TowerList torre2 = new TowerList();
    private TowerList torre3 = new TowerList();
    private TowerList torreReferencia= new TowerList();
    private int movimientos=0;

    public HannoiGame() {
        for (int i = 0; i < this.torre1.size(); i++) {
            Disk disk = new Disk(8 - (i + 1));
            this.torre1.add(disk);
            this.torreReferencia.add(disk);
        }
    }

    public boolean mover(TowerList desde, TowerList hacia) {
        Disk torre = desde.peek();
        try {
            if (hacia.add(torre)) {
                movimientos++;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        desde.add(torre);
        return false;
    }

    public TowerList getTorre1() {
        return torre1;
    }

    public TowerList getTorre2() {
        return torre2;
    }

    public TowerList getTorre3() {
        return torre3;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public TowerList getTorreReferencia() {
        return torreReferencia;
    }
    
}
