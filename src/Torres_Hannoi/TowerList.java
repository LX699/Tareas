package Torres_Hannoi;

import java.util.ArrayList;

public class TowerList implements OwnList<TowerList> {

    private Disk[] disk = new Disk[7];

    public TowerList() {
        for (int i = 0; i < disk.length; i++) {
            disk[i] = new Disk(0);
        }
    }

    @Override
    public int size() {
        return this.disk.length;
    }

    @Override
    public boolean isEmpty() {
        int cantidad = 0;
        for (int i = 0; i < this.disk.length; i++) {
            if (this.disk[i].getTamaño() != 0) {
                cantidad++;
            }
        }
        return (cantidad == 0);
    }

    @Override
    public boolean contains(Disk tobjet) {
        for (int i = 0; i < this.disk.length; i++) {
            if (this.disk[i].getTamaño() == tobjet.getTamaño()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Disk> toArray() {
        ArrayList<Disk> disks = new ArrayList<>();
        for (int i = 0; i < this.disk.length; i++) {
            disks.add(this.disk[i]);
        }
        return disks;
    }

    @Override
    public boolean add(Disk tObjet) {
        for (int i = 0; i < this.disk.length; i++) {
            if ((this.disk[0].getTamaño() == 0) || (this.disk[i].getTamaño() == 0 && this.disk[i - 1].getTamaño() > tObjet.getTamaño())) {
                this.disk[i].setTamaño(tObjet.getTamaño());
                return true;
            }
        }
        return false;
    }

    @Override
    public Disk peek() {
        Disk diskk = new Disk(0);
        for (int i = this.disk.length - 1; i >= 0; i--) {
            if (this.disk[i].getTamaño() != 0) {
                diskk.setTamaño(this.disk[i].getTamaño());
                this.disk[i].setTamaño(0);
                return diskk;
            }
        }
        Disk discoDeFalla = new Disk(0);
        return discoDeFalla;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.disk.length; i++) {
            this.disk[i].setTamaño(0);
        }
    }

    @Override
    public Disk get(int index) {
        index -= 1;
        if (index < 0 || index >= this.disk.length) {
            return null;
        } else if (index < 6 && (this.disk[index + 1].getTamaño() != 0)) {
            return this.disk[index];

        } else if ((index == this.disk.length - 1) && (this.disk[index].getTamaño() != 0)) {
            return this.disk[index];
        }
        return null;

    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < disk.length; i++) {
            info += disk[i].getTamaño();

        }
        return info;
    }

    public boolean esIgual(TowerList torre) {
        int iguales = 0;
        for (int i = 0; i < this.disk.length; i++) {
            if (this.disk[i].getTamaño() == torre.getDisk()[i].getTamaño()) {
                iguales++;
            }
        }
        return (iguales == this.disk.length);
    }

    public Disk[] getDisk() {
        return this.disk;
    }

}
