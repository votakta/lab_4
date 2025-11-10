// создание абстрактного класса - необходим для геометрических фигур
abstract class Geometric {
    protected String name;

// создание конструкторов: 
    public Geometric() {
        this.name = "Геометрическая фигура";
    }
    
    public Geometric(String name) {
        this.name = name;
    }

//абстрактные методы - т.е. тут каждая фигура будет высчитываться по своему
    public abstract double calculateVolume();
    public abstract double calculateSurfaceArea();
    
 // создание геттеров и сетеров - позволяют демонстрирует инкапсуляцию
    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }
}

//класс шар 
 
class Sphere extends Geometric {
    private double radius;
    private static int count = 0;  
    
    public Sphere() {
        super("Шар");
        count++;
    }
    
    public Sphere(double radius) {
        super("Шар");
        this.radius = radius;
        count++;
    }
    
    
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);  
    }
    
    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);  
    }
    

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
    

    public static int getCount() { return count; }
}

//класс параллелепипед 
 
class Parallelepiped extends Geometric {
    private double length;
    private double width;
    private double height;
    

    public Parallelepiped() {
        super("Параллелепипед");
    }
    
    public Parallelepiped(double length, double width, double height) {
        super("Параллелепипед");
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateVolume() {
        return length * width * height;  
    }
    
    @Override
    public double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);  
    }
    
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    
    public void setLength(double length) { this.length = length; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
}

//класс цилиндр 
class Cylinder extends Geometric {
    private double radius;
    private double height;
    
    public Cylinder() {
        super("Цилиндр");
        this.radius = 1.0;
        this.height = 1.0;
    }
    
    public Cylinder(double radius, double height) {
        super("Цилиндр");
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height; 
    }
    
    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height); 
    }
    
    public double getRadius() { return radius; }
    public double getHeight() { return height; }
    
    public void setRadius(double radius) { this.radius = radius; }
    public void setHeight(double height) { this.height = height; }
}

// демонстрация всех принципов ООП
public class GeometricShapes {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ВСЕХ ПРИНЦИПОВ ООП ===\n");
        
        // создание объектов и вывод информации
        System.out.println("1. СОЗДАНИЕ ОБЪЕКТОВ:");
        Sphere sphere1 = new Sphere(7.5);
        System.out.println("   - Шар создан (радиус: " + sphere1.getRadius() + ")");
        
        Parallelepiped box = new Parallelepiped(2.0, 6.0, 8.0);
        System.out.println("   - Параллелепипед создан");
        
        Cylinder cylinder = new Cylinder(3.0, 4.0);
        System.out.println("   - Цилиндр создан");
        
        // демонстрация статического счетчика
        Sphere sphere2 = new Sphere(3.0);
        System.out.println("\n2. СТАТИЧЕСКИЙ СЧЁТЧИК:");
        System.out.println("  - Создан второй шар (радиус: " + sphere2.getRadius() + ")");
        System.out.println("   - Всего создано шаров: " + Sphere.getCount());
        
        // демонстрация полиморфизма
        System.out.println("\n3. ПОЛИМОРФИЗМ (обработка разных фигур через один интерфейс):");
        Geometric[] shapes = {sphere1, box, cylinder};
        for (Geometric shape : shapes) {
            System.out.println("   - " + shape.getName() + 
                             ": объём = " + String.format("%.2f", shape.calculateVolume()) +
                             ", площадь = " + String.format("%.2f", shape.calculateSurfaceArea()));
        }
        
        // инкапсуляция
        System.out.println("\n4. ИНКАПСУЛЯЦИЯ (геттеры/сеттеры):");
        sphere1.setRadius(10.0);
        System.out.println("   - Новый радиус шара: " + sphere1.getRadius());
        System.out.println("   - Новый объём: " + String.format("%.2f", sphere1.calculateVolume()));
        
        System.out.println("\n=== ВСЕ ПУНКТЫ ЗАДАНИЯ ВЫПОЛНЕНЫ ===");
    }
}
