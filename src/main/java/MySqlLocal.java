public class MySqlLocal {
    public static void main(String[] args) {
        SelectMethod tabloliste = new SelectMethod();
        tabloliste.select();
        CreateMethod tabloekle = new CreateMethod();
        tabloekle.create();
        UpdateMethod tablodegistir = new UpdateMethod();
        tablodegistir.degistir();
        DeleteMethod deletemethod = new DeleteMethod();
        deletemethod.sil();
    }
}


