public class RepositoryTicket {
    Ticket[] repoTicket = new Ticket[0];

    public Ticket[] addTicket(Ticket tickets) {
        int lenght = repoTicket.length + 1;
        Ticket[] tmp = new Ticket[lenght];
        for (int i = 0; i < repoTicket.length; i++) {
            tmp[i] = repoTicket[i];
        }
        tmp[tmp.length - 1] = tickets;
        repoTicket = tmp;
        return repoTicket;
    }

    public Ticket[] removeTicket(int id) {
        if (repoTicket.length == 0) {
            throw new NotFoundException("Данного билета нет");
        }
        int index = 0;
        Ticket[] tmp = new Ticket[repoTicket.length];
        for (Ticket ticket : repoTicket) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        Ticket[] tmp2 = new Ticket[index];
        for (int i = 0; i < index; i++) {
            tmp2[i] = tmp[i];
        }

        repoTicket = tmp2;
        return repoTicket;
    }


    public Ticket[] findAll() {
        return repoTicket;
    }


}
