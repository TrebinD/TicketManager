public class Ticket implements Comparable<Ticket> {
    private int id;
    private int coast;
    private String fromAirport;
    private String toAirport;

    public int getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(int timeFlight) {
        this.timeFlight = timeFlight;
    }

    private int timeFlight;

    public Ticket() {
    }

    public Ticket(int id, int coast, String fromAirport, String toAirport, int timeFlight) {
        this.id = id;
        this.coast = coast;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.coast - o.coast;
    }
}
