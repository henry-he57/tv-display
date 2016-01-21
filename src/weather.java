
import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 * @author Adam Morrison
 */
public class weather extends javax.swing.JPanel {

    Timer t1 = new Timer(60000, (ActionListener) new TimerListener()); // declare timer object for once a minute

    WeatherDoc doc = new WeatherDoc("4113", "c"); // Weather API location and units system

    WeatherDisplay disp = new WeatherDisplay(); // Create WeatherDisplay object

    String temp, tempU, conditions, wChill; // global string variable that will hold the conditions
    
    // setting varios images to be used as weather icons
    Image weatherBackground = Toolkit.getDefaultToolkit().getImage("space25.jpg");
    Image mixedRainAndSnow = Toolkit.getDefaultToolkit().getImage("weatherIcons\\mixed rain and snow.png");
    Image partlyCloudy = Toolkit.getDefaultToolkit().getImage("weatherIcons\\partly cloudy.png");
    Image cloudy = Toolkit.getDefaultToolkit().getImage("weatherIcons\\cloudy.png");
    Image mostlyCloudy = Toolkit.getDefaultToolkit().getImage("weatherIcons\\mostly cloudy.png");
    Image scatteredShowers = Toolkit.getDefaultToolkit().getImage("weatherIcons\\scattered showers.png");
    Image showers = Toolkit.getDefaultToolkit().getImage("weatherIcons\\showers.png");
    Image snow = Toolkit.getDefaultToolkit().getImage("weatherIcons\\snow.png");
    Image sunny = Toolkit.getDefaultToolkit().getImage("weatherIcons\\sunny.png");
    Image tornado = Toolkit.getDefaultToolkit().getImage("weatherIcons\\ tornado.png");

    Font font; // font variable

    /**
     * Creates new form weather
     */
    public weather() {
        initComponents();
    }

    /**
     * starts timer, and displays the current weather
     */
    public void start() {
        t1.start();
        getWeather();
        repaint();
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            getWeather();   // call the getWeather method
            repaint();      // call the paintComponent method
        }
    }

    /**
     * gets the current weather conditions
     */
    private void getWeather() {
        temp = disp.getTemperature(); // sets temp to the current temurature
        tempU = disp.getTemperatureUnit(); // sets tempU to the current unit being used
        conditions = disp.getCondition(); // sets conditions to the current condition
        wChill = disp.getWindChill(); // sets wChil to the current wind chill
    }

    /**
     * displays text for the weather
     * @param g Graphics object
     */
    private void showWeather(Graphics g) {
        font = new Font("Calisto MT", Font.PLAIN, 15); // set font type
        g.setFont(font); // set the graphics object to the font Font
        g.setColor(Color.white); // set the graphics object to the colour white
        g.drawString(" Conditions: " + conditions, 0, 290); // display the conditions
        g.drawString(" Tempurture: " + temp + " " + tempU, 0, 310); // display the tempurature
        g.drawString(" Wind chill: " + wChill + " " + tempU, 0, 330); // display the wind chill
    }

    public void paintComponent(Graphics g) {
        g.drawImage(weatherBackground, 0, 0, this); // draw background image
        Image show = null;
        if (conditions.equals("Light Snow Shower")) {
            show = mixedRainAndSnow;
        } else if (conditions.equals("Partly Cloudy")) {
            show = partlyCloudy;
        } else if (conditions.equals("Couldy")) {
            show = cloudy;
        } else if (conditions.equals("Mostly Cloudy")) {
            show = mostlyCloudy;
        } else if (conditions.equals("Scattered Showers")) {
            show = scatteredShowers;
        } else if (conditions.equals("Scattered Snow Showers")) {
            show = mixedRainAndSnow;
        } else if (conditions.equals("Showers")) {
            show = showers;
        } else if (conditions.equals("Mixed Rain and Snow")) {
            show = mixedRainAndSnow;
        } else if (conditions.equals("Drizzle")) {
            show = showers;
        } else if (conditions.equals("Snow Flurries")) {
            show = snow;
        } else if (conditions.equals("Snow")) {
            show = snow;
        } else if (conditions.equals("Sunny")) {
            show = sunny;
        } else if (conditions.equals("Heavy Snow")){
            show = snow;
        } else if (conditions.equals("Snow Showers")){
            show = snow;
        }
        g.drawImage(show, -15, -125, this); // draw whatever the condition is currently
        showWeather(g); // call the showWeather meathod with the Graphics
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
