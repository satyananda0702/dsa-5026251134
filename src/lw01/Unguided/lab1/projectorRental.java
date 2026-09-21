package lw01.Unguided.lab1;

public class projectorRental extends Rental {

    public projectorRental(String id, int days) {

        super(id, days);

    }

    @Override

    public int calculateCharge() {

        int days = getDays();

        int normalDays = Math.min(days, 3);

        int extraDays = Math.max(days - 3, 0);

        return normalDays * 60000 + extraDays * 45000 +20000;

    }

    @Override

    public String label() {

        return "Projector";

    }
}