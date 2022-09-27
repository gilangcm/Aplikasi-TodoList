import java.util.Scanner;

public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * menampilkan todo List
     */
    public static void showTodoList(){
    for (var i = 0; i < model.length; i++){
        var todo = model[i];
        var no = i + 1;

        if (todo != null){
            System.out.println(no + ". " + todo );

        }
    }
    }

    public static void testShowTodoList(){
        model[0]="belajar todo list";
        model[1]="tes awal";
        showTodoList();
    }

    /**
     * menambahkan todo ke List
     */
    public static void addTodoList(String todo){

        var isFull = true;
        //cek apakah model penuh?
        for (var i = 0; i < model.length; i++){
            if (model[i]== null){
                isFull = false;
                break;
            }
        }
        //jika isFull kita resize 2x lipat
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }

        }

    //tambahkan ke posisi data array yang NULL
    for (var i = 0; i < model.length; i++){
        if (model[i] == null){
            model[i] = todo;
            break;
        }
    }
    }

    public static void testAddTodoList(){
        for (var i = 0; i < 25; i++){
            addTodoList("contoh Todo ke " + i);
        }
        showTodoList();
    }

    /**
     * menghapus todo dari List
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;

        } else {
            for (int i = (number - 1); i < model.length;i++){
                if (i == model.length - 1){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(6);
        System.out.println(result);

        result = removeTodoList(3);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * menampilkan view todo List
     */
    public static void viewShowTodoList(){
        System.out.println("TODOLIST");
    while (true){
        showTodoList();

        System.out.println("MENU : ");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");

        var input = input("pilih");

        if (input.equals("1")){
            viewAddTodoList();
        } else if (input.equals("2")) {
            viewRemoveTodoList();
        } else if (input.equalsIgnoreCase("x")) {
            break;
        } else {
            System.out.println("Pilihan Tidak Dimengerti");
        }
    }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        viewShowTodoList();
    }

    /**
     * menampilkan view menambahkan todo List
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");
        var todo = input("Todo (x jika batal)");

        if (todo.equalsIgnoreCase("x")){
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");


        viewAddTodoList();

        showTodoList();
    }

    /**
     * menampilkan view menghapus todo List
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("NOMOR TODOLIST YANG AKAN DIHAPUS (x jika batal)");

        if (number.equalsIgnoreCase("x")){
            //batal
        }else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("GAGAL MENGHAPUS TODOLIST " + number);
            }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodoList("SATU");
        addTodoList("DUA");
        addTodoList("TIGA");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
