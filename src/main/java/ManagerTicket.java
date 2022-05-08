public class ManagerTicket {

    public RepositoryTicket repository;

    public ManagerTicket(RepositoryTicket repository) {
        this.repository = repository;
    }


    public Ticket[] find() {
        return repository.findAll();
    }

    public void add(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public void remove(int id) {
        repository.removeTicket(id);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (matches(product, from) && matches2(product, to)) {
                int leghth = result.length + 1;
                Ticket[] tmp = new Ticket[leghth];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Ticket ticket, String search) {
        if (ticket.getFromAirport().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matches2(Ticket ticket, String search) {
        if (ticket.getToAirport().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
