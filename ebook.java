import java.util.*;
import java.io.*;
import java.sql.*;
class vbvb{
    static String uname;
    static String pass;
    static String s="\u001B[0m";
    static   String v="\u001B[34m";
    static  String re="\u001B[31m";
    static    String p="\u001B[35m";
    public static void main(String[] args) throws Exception {
        String vv="\u001B[41m";
        vbvb r= new vbvb();
        r.printWelcomePattern();
        Scanner sc = new Scanner(System.in);
        int y=0;
        while(y!=1)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root","");
            System.out.println(v+"-----1.login-----"+s);
            System.out.println(v+"-----2.sign in-----"+s);
            System.out.print(v+"Enter choice : "+s);
            int u=sc.nextInt();
            switch (u) {
                case 1:
                
                System.out.print(p+"Enter user name : "+s);
                uname = sc.next();
                System.out.print(p+"Enter password : "+s);
                pass = sc.next();
                String qq="select user_id from user where user_name='"+uname+"'";
                Statement st=con.createStatement();
                ResultSet rs1=st.executeQuery(qq);
                int uu;
                while (rs1.next()) {
                     uu=rs1.getInt(1);
                     String sqq="insert into logins(user_id,user_name) values(?,?)";
                     PreparedStatement prt=con.prepareStatement(sqq);
                     prt.setInt(1, uu);
                     prt.setString(2,uname);
                     prt.executeUpdate();
                }
                
            
                String sql8 = "SELECT pass_code FROM user WHERE user_name = ?"; 
                PreparedStatement pst = con.prepareStatement(sql8); 
                pst.setString(1, uname); 
                ResultSet rs = pst.executeQuery(); 
                
                if(rs.next()) {
                    String dbPass = rs.getString("pass_code");
                    if(pass.equals(dbPass)) {
                        r.gg();
                        break;
                    } else {
                        System.out.println("Wrong password");
                        y = 1;
                        break;
                    }
                } else {
                    System.out.println("username not found");
                    y = 1;
                    break;
                }
                case 2 :
                     System.out.print("Enter username: ");
                     String username = sc.next();
                     System.out.print("Enter password: ");
                     String password = sc.next();
             
                     String sql = "INSERT INTO user (user_name, pass_code) VALUES (?, ?)";
                     PreparedStatement ps = con.prepareStatement(sql);
                     ps.setString(1, username);
                     ps.setString(2, password);
                     ps.executeUpdate();
             
                     System.out.println("User registered successfully!");
                        break;
                default:
                    break;
            }
        }
    }
    void gg()throws Exception
    {
        int w=1;
        Scanner sc= new Scanner(System.in);
        while(w!=0)
        {
            System.out.println("Enter choice:");
        System.out.println("1: Read book");
        System.out.println("2: Read category names");
        System.out.println("3: Read books name");
        System.out.println("4: Add books name in readlist");
        System.out.println("5: Read your readlist");
        System.out.println("6: Delete book name from readlist");
        System.out.println("7: Exit");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                    w=1;
                    //r.connection();
                    bookread(); // Call bookread method
                break;
            case 2:
                    w=1;
                    readcateg(); 
                    break;  
            case 3:
                    w=1;
                    readname();
                    break;
            case 4:
                    w=1;  
                    add_in_list();
                    break;
            case 5:
                    w=1;
                    read_list();
                    break;  
            case 6:
                     w=1; 
                     delete();
                     break;         
            case 7:
                    w=0;
                    break;        
            default:
                System.out.println("Invalid choice.");
                break;
            }
        }
    }

    void bookread() throws Exception
     {
        
        readcateg();
        Scanner sc= new Scanner(System.in);
        System.out.println("Choose a category:");
        int ch2=sc.nextInt();
        switch (ch2) {
            case 1:
                Horror();
                break;
            case 2:
                Fantasy();
                break;
            case 3:
                Science_fiction();
                break;
            case 4:
                Mystery();
                break;     
            case 5:
                Romance_novel();
                break;  
            case 6:
                History(); 
                break;
            case 7:
                Cookbook();
                break;
            case 8:
                Children_literature();
                break; 
            case 9:
                Biography();
                break;
            case 10:
                Thriller();    
            default:
                break;
        }
       
    }

    void BOOKS(String b) throws IOException {
        File pdfFile = new File(b);
        byte[] bq = new byte[(int) pdfFile.length()];
        FileInputStream fis = new FileInputStream(pdfFile);
            fis.read(bq);
            System.out.println("File read successfully. Length: " + bq.length);

        // Write the same content back to a new PDF
        FileOutputStream fos = new FileOutputStream("pdf/proj1_copy.pdf");
            fos.write(bq);
            System.out.println("File copied successfully to proj1_copy.pdf");
    }
  void readcateg() throws Exception
  {
    String r="\u001B[0m";
    String y="\u001B[33m";
    String b="\u001B[34m";
    String dburl = "jdbc:mysql://localhost:3306/ebook";
    String dbuser = "root";
    String dbpass = "";
    String drivername = "com.mysql.cj.jdbc.Driver";

    Class.forName(drivername);

    try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpass)) {
        if (con != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Failure");
        }
        Statement st = con.createStatement();
        String query = "SELECT * FROM category";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.print(y+rs.getString(1)+r + " ");
            System.out.print(b+rs.getString(2)+r);
            System.out.println();
        }
    } catch (SQLException e) {
        System.out.println("Error executing query: " + e.getMessage());
    }
  }
   void readname()throws Exception
   {
        Scanner sc= new Scanner(System.in);
        readcateg();
        System.out.println("Of Which category books name you want to see");
        int num1=sc.nextInt();
        int o=0;
        switch (num1) {
            case 1:
                o=1;
                break;
            case 2:
             o=2;
            break;
            case 3:
            o=3;
            break;
            case 4:
            o=4;
            break;
            case 5:
            o=5;
            break;
            case 6:
            o=6;
            break;
            case 7:
            o=7;
            break;
            case 8:
            o=8;
            break;
            case 9:
            o=9;
            break;
            case 10:
            o=10;
            break;
            default:
                break;
        }
        String name = "com.mysql.cj.jdbc.Driver";
        Class.forName(name);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root", "");
        String sql="select book_id,book_name from books  where  cate_id="+o+";";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        String r="\u001B[0m";
        String v="\u001B[35m";
        String g="\u001B[32m";
        while (rs.next()) {
            System.out.println(v+rs.getInt(1)+r+"---------"+g+rs.getString(2)+r);
        }
   }
   void Horror() throws Exception
   {
    /*String url1="pdfs/txtFile/Horror.txt";
    calling(url1);*/
    int n=1;
    bookname(n);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch (y) {
        case 1:
             url = "pdfs/Horror/carmilla.pdf"; // Ensure this path is correct
             System.out.println("BOOK NAME : carmilla  ");
            BOOKS(url);
            break;
        case 2:
            url="pdfs/Horror/dracula bram stoker.pdf";
            System.out.println("BOOK NAME : dracula bram stoker ");
            BOOKS(url);
            break;
        case 3:
            url="pdfs/Horror/frankenstein marysh elley.pdf";
            System.out.println("BOOK NAME : dracula bram stoker ");
            BOOKS(url);
            break;
        case 4: 
            url="pdfs/Horror/the black cat.pdf";
            System.out.println("BOOK NAME :frankenstein marysh elley ");
            BOOKS(url);
            break;
        case 5:
            url="pdfs/Horror/the call of cthulhu.pdf"; 
            System.out.println("BOOK NAME : the call of cthulhu ");
            BOOKS(url);
            break;
         case 6:
            url="pdfs/Horror/the canterville ghost.pdf";
            System.out.println("BOOK NAME : the canterville ghost ");
            BOOKS(url);
            break;
         case 7:
            url="pdfs/Horror/The Golem Author Gustav Meyrink.pdf";
            System.out.println("BOOK NAME :The Golem Author Gustav Meyrink");
            BOOKS(url);
            break;
        case 8:
            url="pdfs/Horror/the phantom of the opera.pdf";
            System.out.println("BOOK NAME : the phantom of the opera ");
            BOOKS(url); 
            break;
        case 9:
            url="pdfs/Horror/the portrait of dorian gray.pdf";
            System.out.println("BOOK NAME : the portrait of dorian gray");
            BOOKS(url);
            break;                    
            default:
            System.out.println("Invalid choice.");
            break;
    }
   }
   void Fantasy() throws Exception
   {
        Scanner sc= new Scanner(System.in);
        /*String as="pdfs/txtFile/Fantasy.txt";
        calling(as);*/
        int n=2;
    bookname(n);
        System.out.println("Which books you want to read");
        int fn = sc.nextInt();
        String url;
        switch ((fn)) {
            case 10:
                url="pdfs/Fantasy/A Journey to the Centre of the Earth.pdf";
                System.out.println("BOOK NAME : A Journey to the Centre of the Earth");
                BOOKS(url);
                return;
            case 11:
                url="pdfs/Fantasy/Bleak House.pdf";
                System.out.println("BOOK NAME : Bleak House");
                BOOKS(url);
                break;
            case 12:
                url="pdfs/Fantasy/From The Earth To The Moon.pdf";
                System.out.println("BOOK NAME : From The Earth To The Moon");
                BOOKS(url);
                break;   
            case 13:
                url="pdfs/Fantasy/The Adventure of Pinocchio.pdf";
                System.out.println("BOOK NAME :The Adventure of Pinocchio");
                BOOKS(url);
                break;
            case 14:
                url="pdfs/Fantasy/The Island of Doctor Moreau.pdf";
                System.out.println("BOOK NAME :The Island of Doctor Moreau");
                BOOKS(url);
                break;
            case 15:
                url="pdfs/Fantasy/The Mysterious Island.pdf";
                System.out.println("BOOK NAME :The Mysterious Island");
                BOOKS(url);
                break;  
            case 16:
                url="pdfs/Fantasy/The Night Land.pdf";
                System.out.println("BOOK NAME : The Night Land");
                BOOKS(url);
                break; 
            case 17:
                url="pdfs/Fantasy/The Wonderful Wizard of Oz.pdf";
                System.out.println("BOOK NAME :The Wonderful Wizard of Oz");
                BOOKS(url);
                break; 
            case 18:
                url="pdfs/Fantasy/The Wood Beyond the World.pdf";
                System.out.println("BOOK NAME : The Wood Beyond the World");
                BOOKS(url);
                break;                 
            default:
                break;
        }
   }
   void Science_fiction() throws Exception
   {
        /*String url2="pdfs/txtFile/Science fiction.txt";
        calling(url2);*/
        int n=3;
    bookname(n);
        Scanner sc = new Scanner(System.in);
        System.out.println("Which books you want to read");
        int y = sc.nextInt();
        String url;
        switch (y) {
            case 19:
                url="pdfs/Science fiction/Around the Moon.pdf";
                System.out.println("BOOK NAME : Around the Moon");
                BOOKS(url);
                break;
            case 20:
                url="pdfs/Science fiction/Caesar's Column.pdf";
                System.out.println("BOOK NAME :Caesar's Column");
                BOOKS(url);
                break;
            case 21:
                url="pdfs/Science fiction/Nineteen Eighty Four.pdf";
                System.out.println("BOOK NAME : Nineteen Eighty Four");
                BOOKS(url);
                break;
            case 22:
                url="pdfs/Science fiction/The Artist of the Beautiful.pdf";
                System.out.println("BOOK NAME : The Artist of the Beautiful");
                BOOKS(url);
                break;
            case 23:
                url="pdfs/Science fiction/The Blazing World.pdf";
                System.out.println("BOOK NAME : The Blazing World");
                BOOKS(url);
                break; 
            case 24:
                url="pdfs/Science fiction/The Brick Moon.pdf";
                System.out.println("BOOK NAME : The Brick Moon");
                BOOKS(url);
                break; 
            case 25:
                url="pdfs/Science fiction/The Lost World.pdf";
                System.out.println("BOOK NAME :The Lost World");
                BOOKS(url);
                break; 
            case 26:
                url="pdfs/Science fiction/The Time Machine.pdf";
                System.out.println("BOOK NAME : The Time Machine");
                BOOKS(url);
                break;
            case 27:
                url="pdfs/Science fiction/Twenty Thousand Leagues Under the Seas.pdf";
                System.out.println("BOOK NAME :Twenty Thousand Leagues Under the Seas");
                BOOKS(url);
                break;                       
            default:
                break;
        }
   }
   void Mystery()throws Exception
   {
    /*String url2="pdfs/txtFile/Mystery.txt";
    calling(url2);*/
    int n=4;
    bookname(n);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch ((y)) {
        case 28:
            url="pdfs/Mystery/A Study in Scarlet.pdf";
            System.out.println("BOOK NAME:A Study in Scarlet");
            BOOKS(url);
            break;
        case 29:
            url="pdfs/Mystery/In the Fog.pdf";
            System.out.println("BOOK NAME:In the Fog");
            BOOKS(url);   
            break;
        case 30:
            url="pdfs/Mystery/The Adventures of Sherlock Holmes.pdf";
            System.out.println("BOOK NAME:The Adventures of Sherlock Holmes");
            BOOKS(url);
            break;
        case 31:
            url="pdfs/Mystery/The Lodger.pdf";
            System.out.println("BOOK NAME:The Lodger");
            BOOKS(url); 
            break;
        case 32:
            url="pdfs/Mystery/The Murders in the Rue Morgue.pdf";
            System.out.println("BOOK NAME:The Murders in the Rue Morgue");
            BOOKS(url); 
            break;
        case 33:
            url="pdfs/Mystery/The Mysterious Affair at Styles.pdf";
            System.out.println("BOOK NAME:The Mysterious Affair at Styles");
            BOOKS(url);
            break;
        case 34:
            url="pdfs/Mystery/The Red House Mystery.pdf";
            System.out.println("BOOK NAME:The Red House Mystery");
            BOOKS(url);
            break;
        case 35:
            url="pdfs/Mystery/The Sign of Four.pdf";
            System.out.println("BOOK NAME:The Sign of Four");
            BOOKS(url); 
            break;
        case 36:
            url="pdfs/Mystery/The vampire.pdf";
            System.out.println("BOOK NAME:The vampire");
            BOOKS(url); 
            break;    
        default:
            break;
    }
   }
   void Romance_novel() throws Exception
   {
    //String url2="pdfs/txtFile/Romance novel.txt";
    //calling(url2);
    int n=5;
    bookname(n);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch (y) {
        case 37:
            url="pdfs/Romance novel/Lady Chatterley's Lover .pdf";
            System.out.println("BOOK NAME:Lady Chatterley's Lover ");
            BOOKS(url);
            break;
        case 38:
            url="pdfs/Romance novel/Sense and Sensibility.pdf";
            System.out.println("BOOK NAME:Sense and Sensibility");
            BOOKS(url);
            break;
        case 39:
            url="pdfs/Romance novel/Anna Karenina.pdf";
            System.out.println("BOOK NAME:Anna Karenina");
            BOOKS(url);
            break;
        case 40:
            url="pdfs/Romance novel/A Room with a View.pdf";
            System.out.println("BOOK NAME:A Room with a View");
            BOOKS(url);
            break;
        case 41:
            url="pdfs/Romance novel/Emma.pdf";
            System.out.println("BOOK NAME:Emma");
            BOOKS(url);
            break;
        case 42:
            url="pdfs/Romance novel/Jane Eyre.pdf";
            System.out.println("BOOK NAME:Jane Eyre");
            BOOKS(url);
            break;
        case 43:
            url="pdfs/Romance novel/Pride and Prejudice.pdf";
            System.out.println("BOOK NAME:Pride and Prejudice");
            BOOKS(url);
            break;
        case 44:
            url="pdfs/Romance novel/Persuasion.pdf";
            System.out.println("BOOK NAME:Persuasion");
            BOOKS(url);
            break;
        case 45:
            url="pdfs/Romance novel/The Lady of the Camellias.pdf";
            System.out.println("BOOK NAME:The Lady of the Camellias");
            BOOKS(url);
            break;
        default:
            break;
    }
   }
   void History()throws Exception
   {
    /*String url2="pdfs/txtFile/History.txt";
    calling(url2);*/
    int n=6;
    bookname(n);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch (y) {
        case 46:
            url="pdfs/History/Floor Games.pdf";
            System.out.println("BOOK NAME:Floor Games");
            BOOKS(url);
            break;
        case 47:
            url="pdfs/History/The Discovery of the Future.pdf";
            System.out.println("BOOK NAME:The Discovery of the Future");
            BOOKS(url);
            break;
        case 48:
            url="pdfs/History/The Time Machine.pdf";
            System.out.println("BOOK NAME:The Time Machine");
            BOOKS(url);
            break;
        case 49:
            url="pdfs/History/This Misery of Boots.pdf";
            System.out.println("BOOK NAME:This Misery of Boots");
            BOOKS(url);
            break;
        case 50:
            url="pdfs/History/A Short History of the World.pdf";
            System.out.println("BOOK NAME:A Short History of the World");
            BOOKS(url);
            break;
        case 51:
            url="pdfs/History/The Wonderful Visit.pdf";
            System.out.println("BOOK NAME:The Wonderful Visit");
            BOOKS(url);
            break;
        case 52:
            url="pdfs/History/The Island of Dr. Moreau.pdf";
            System.out.println("BOOK NAME:The Island of Dr. Moreau");
            BOOKS(url);
            break;
        case 53:
            url="pdfs/History/The Invisible Man.pdf";
            System.out.println("BOOK NAME:The Invisible Man");
            BOOKS(url);
            break;
        case 54:
            url="pdfs/History/The Wheels of Chance.pdf";
            System.out.println("BOOK NAME:The Wheels of Chance");
            BOOKS(url);
            break;
        default:
            break;
    }
   }
   void Cookbook()throws Exception
   {
    /*String url2="pdfs/txtFile/Cookbook.txt";
    calling(url2);*/
    int n=7;
    bookname(n);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch (y) {
        case 55:
        url="pdfs/Cookbook/Traditional foods of india.pdf";
        System.out.println("BOOK NAME:Traditional foods of india");
        BOOKS(url);
        break;
    case 56:
        url="pdfs/Cookbook/Central and South Indian Cuisine.pdf";
        System.out.println("BOOK NAME:Central and South Indian Cuisine");
        BOOKS(url);
        break;
    case 57:
        url="pdfs/Cookbook/Pita Bread Pizza Crust.pdf";
        System.out.println("BOOK NAME:Pita Bread Pizza Crust");
        BOOKS(url);
        break;
    case 58:
        url="pdfs/Cookbook/13 Proven Health Benefits of Coffee.pdf";
        System.out.println("BOOK NAME:13 Proven Health Benefits of Coffee");
        BOOKS(url);
        break;
    case 59:
        url="pdfs/Cookbook/Coffee Recipes.pdf";
        System.out.println("BOOK NAME:Coffee Recipes");
        BOOKS(url);
        break;
    case 60:
        url="pdfs/Cookbook/Chocolate Recipe Book.pdf";
        System.out.println("BOOK NAME:Chocolate Recipe Book");
        BOOKS(url);
        break;
    case 61:
        url="pdfs/Cookbook/Best of Indian Vegetarian Recipes.pdf";
        System.out.println("BOOK NAME:Best of Indian Vegetarian Recipes");
        BOOKS(url);
        break;
    case 62:
        url="pdfs/Cookbook/Thai green curry paste.pdf";
        System.out.println("BOOK NAME:Thai green curry paste");
        BOOKS(url);
        break;
    case 63:
        url="pdfs/Cookbook/The Little book of sushi.pdf";
        System.out.println("BOOK NAME:The Little book of sushi");
        BOOKS(url);
        break;
    default:
        break;
    }
   }
   void Children_literature()throws Exception
   {
        /*String url2="pdfs/txtFile/Children's literature.txt";
        calling(url2);*/
        int n=8;
    bookname(n);
        Scanner sc = new Scanner(System.in);
        System.out.println("Which books you want to read");
        int y = sc.nextInt();
        String url;
        switch ((y)) {
            case 64:
                url="pdfs/Children's literature/The Pirate Frog, and Other Tales.pdf";
                System.out.println("BOOK NAME:The Pirate Frog, and Other Tales");
                BOOKS(url);
                break;
            case 65:
                url="pdfs/Children's literature/Philosophy for children.pdf";
                System.out.println("BOOK NAME:Philosophy for children");
                BOOKS(url);
                break;
            case 66:
                url="pdfs/Children's literature/Basic Short Vowels.pdf";
                System.out.println("BOOK NAME:Basic Short Vowels");
                BOOKS(url);
                break;
            case 67:
                url="pdfs/Children's literature/Run!!! A ghost comes.pdf";
                System.out.println("BOOK NAME:Run!!! A ghost comes");
                BOOKS(url);
                break;
            case 68:
                url="pdfs/Children's literature/The Little Mermaid.pdf";
                System.out.println("BOOK NAME:The Little Mermaid");
                BOOKS(url);
                break;
            case 69:
                url="pdfs/Children's literature/Dinosaurs On Alaska’s North Slope.pdf";
                System.out.println("BOOK NAME:Dinosaurs On Alaska’s North Slope");
                BOOKS(url);
                break;
            case 70:
                url="pdfs/Children's literature/A Unicorn.pdf";
                System.out.println("BOOK NAME:A Unicorn");
                BOOKS(url);
                break;
            case 71:
                url="pdfs/Children's literature/Cinderella.pdf";
                System.out.println("BOOK NAME:Cinderella");
                BOOKS(url);
                break;
            case 72:
                url="pdfs/Children's literature/Funny Riddles.pdf";
                System.out.println("BOOK NAME:Funny Riddles");
                BOOKS(url);
                break;
                
            default:
                break;
        }
   }
   void Biography()throws Exception
   {
    /*String url2="pdfs/txtFile/Biography.txt";
    calling(url2);*/
    int n=9;
    bookname(n);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch (y) {
        case 73:
            url="pdfs/Biography/Albert Einstein .pdf";
            System.out.println("BOOK NAME:Albert Einstein");
            BOOKS(url);
            break;
        case 74:
            url="pdfs/Biography/The Story of Gandhi.pdf";
            System.out.println("BOOK NAME:The Story of Gandhi");
            BOOKS(url);
            break;
        case 75:
            url="pdfs/Biography/Nelson mandela biography.pdf";
            System.out.println("BOOK NAME:Nelson mandela biography");
            BOOKS(url);
            break;
        case 76:
            url="pdfs/Biography/A P J Abdul kalam.pdf";
            System.out.println("BOOK NAME:A P J Abdul kalam");
            BOOKS(url);
            break;
        case 77:
            url="pdfs/Biography/Mother Teresa.pdf";
            System.out.println("BOOK NAME:Mother Teresa");
            BOOKS(url);
            break;
        case 78:
            url="pdfs/Biography/Rabindranath Tagore.pdf";
            System.out.println("BOOK NAME:Rabindranath Tagore");
            BOOKS(url);
            break;
        case 79:
            url="pdfs/Biography/Sarojini Naidu.pdf";
            System.out.println("BOOK NAME:Sarojini Naidu");
            BOOKS(url);
            break;
        case 80:
            url="pdfs/Biography/MS DHONI.pdf";
            System.out.println("BOOK NAME:MS DHONI");
            BOOKS(url);
            break;
        case 81:
            url="pdfs/Biography/Aryabhatta.pdf";
            System.out.println("BOOK NAME:Aryabhatta");
            BOOKS(url);
            break;
        default:
            break;
    }
   }
   void Thriller()throws Exception
   {
   /* String url2="pdfs/txtFile/Thriller.txt";
    calling(url2);*/
    int id=10;
    bookname(id);
    Scanner sc = new Scanner(System.in);
    System.out.println("Which books you want to read");
    int y = sc.nextInt();
    String url;
    switch (y) {
        case 82:
            url="pdfs/Thriller/The Woman in White.pdf";
            System.out.println("BOOK NAME:.The Woman in White");
            BOOKS(url);
            break;
        case 83:
            url="pdfs/Thriller/The Devil's Elixir.pdf";
            System.out.println("BOOK NAME:The Devil's Elixir");
            BOOKS(url);
            break;
        case 84:
            url="pdfs/Thriller/The Riddle of the Sands.pdf";
            System.out.println("BOOK NAME:The Riddle of the Sands");
            BOOKS(url);
            break;
        case 85:
            url="pdfs/Thriller/Wylder's Hand.pdf";
            System.out.println("BOOK NAME:Wylder's Hand");
            BOOKS(url);
            break;
        case 86:
            url="pdfs/Thriller/Northanger Abbey.pdf";
            System.out.println("BOOK NAME:Northanger Abbey");
            BOOKS(url);
            break;
        case 87:
            url="pdfs/Thriller/Original Short Stories.pdf";
            System.out.println("BOOK NAME:Original Short Stories");
            BOOKS(url);
            break;
        case 88:
            url="pdfs/Thriller/The Moonstone.pdf";
            System.out.println("BOOK NAME:The Moonstone");
            BOOKS(url);
            break;
        case 89:
            url="pdfs/Thriller/The Count of MonteCristo.pdf";
            System.out.println("BOOK NAME:The Count of MonteCristo");
            BOOKS(url);
            break;
        case 90:
            url="pdfs/Thriller/The Last Man.pdf";
            System.out.println("BOOK NAME:The Last Man");
            BOOKS(url);
            break;
        default:
            break;
    }
   }
   void connection() throws Exception {
    String dburl = "jdbc:mysql://localhost:3306/ebook";
    String dbuser = "root";
    String dbpass = "";
    String drivername = "com.mysql.jdbc.Driver";

    Class.forName(drivername);

    try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpass)) {
        if (con != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Failure");
        }
    }
   }
   void bookname(int n) throws Exception
   {

        String name = "com.mysql.cj.jdbc.Driver";
        Class.forName(name);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root", "");
        String sql="select book_id,book_name from books  where  cate_id="+n+";";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        String r="\u001B[0m";
        String v="\u001B[35m";
        String g="\u001B[32m";
        while (rs.next()) {
            System.out.println(v+rs.getInt(1)+r+"---------"+g+rs.getString(2)+r);
        }
   }
   void readlist() throws Exception
   {
    String name = "com.mysql.cj.jdbc.Driver";
    Class.forName(name);
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root", "");
    readcateg();
    Scanner sc=new Scanner(System.in);
    System.out.print ("which category book you want to add in your readlist : ");
    int i= sc.nextInt();
    int o;
    switch (i) {
        case 1:
            o=1;
            bookname(o);
            break;
        case 2:
         o=2;
        bookname(o);
        break;
        case 3:
        o=3;
        bookname(o);
        break;
        case 4:
        o=4;
        bookname(o);
        break;
        case 5:
        o=5;
        bookname(o);
        break;
        case 6:
        o=6;
        bookname(o);
        break;
        case 7:
        o=7;
        bookname(o);
        break;
        case 8:
        o=8;
        bookname(o);
        break;
        case 9:
        o=9;
        bookname(o);
        break;
        case 10:
        o=10;
        bookname(o);
        break;
        default:
            break;
    }
   }
   void add_in_list() throws Exception
   {
    String name = "com.mysql.cj.jdbc.Driver";
    Class.forName(name);
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root", "");
    Statement st= con.createStatement();    
    int s[];
        int top=-1,cap;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of books you want to add");
        cap=sc.nextInt();
        s=new int[cap];
        for(int i=0;i<cap;i++)
        {
            readlist();
            if(top==cap-1)
        {
            System.out.println("underflow");
        }
        else
        {
            top++;
            System.out.print("Which book id you want to add in your readlist : ");
            int a=sc.nextInt();
            s[top]=a;
            }
        }
        System.out.print("Selected books id : ");
        for(int l=top;l>=0;l--)
        {
            System.out.print(s[l]+" ");
        }
        System.out.println();
        for(int l=top;l>=0;l--)
        {
            if(top==-1)
        {
            System.out.println("underflow");
        }
        else{
            String sql="select book_name from books where book_id="+s[top]+";";
            ResultSet rs=st.executeQuery(sql);
            String bn;
            String sql1;
            while(rs.next())
            {
                 bn=rs.getString(1);
                 sql1="insert into readlist(user_name,book_id,book_name) values(?,?,?);";
                 PreparedStatement pst=con.prepareStatement(sql1);
                 pst.setString(1,uname);
                 pst.setInt(2,s[top]);
                 pst.setString(3, bn);
                 pst.execute();
            }   
            top--;
        }
        }
   }  
   void read_list()throws Exception
   {
    String r="\u001B[0m";
        String y="\u001B[33m";
        String b="\u001B[34m";
    String name = "com.mysql.cj.jdbc.Driver";
    Class.forName(name);
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root", "");
    Statement st=con.createStatement();
    String sql="select book_id,book_name from readlist where user_name='"+uname+"';";
    ResultSet rs=st.executeQuery(sql);
    while(rs.next())
    {
        System.out.println(y+"book id :"+b+rs.getInt(1)+r+y+" book name :"+b+rs.getString(2)+r);
    }
   }
   void delete()throws Exception
   {
    Scanner sc= new Scanner(System.in);
    String name = "com.mysql.cj.jdbc.Driver";
    Class.forName(name);
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook", "root", "");
    System.out.println("Mark book as Completed");
    read_list();
    System.out.println("Enter book id to delete");
    int g=sc.nextInt();
    String sql="delete from readlist where book_id="+g+";";
    Statement st=con.createStatement();
    st.execute(sql);
   }
   void printWelcomePattern() {
    String[] lines = {
        "**************************************",
            "*                                    *",
            "*   W E L C O M E  T O  T H E       *",
            "*   E - B O O K  S Y S T E M         *",
            "*                                    *",
            "**************************************"
    };

    for (String line : lines) {
        System.out.println(line);
    }
}
}