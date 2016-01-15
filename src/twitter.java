import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import javax.swing.Timer;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author night
 */

public class twitter extends javax.swing.JPanel {

    Timer tweetRefresh = new Timer (120000, (ActionListener) new TimerListener());
     //Your Twitter App's Consumer Key
    String consumerKey = "iuQCb5R7W28H46DAMzUHM2slo";

    //Your Twitter App's Consumer Secret
    String consumerSecret = "pZxzt1uHOoKByI1Gr6ub0lUME3K4xLdxLzKvzfZsfHYesd5bJ5";

    //Your Twitter Access Token
    String accessToken = "4736054183-0r6cUOMERw9Y3lSqZAefJxFSOJ9LHWaa90WlP84";

    //Your Twitter Access Token Secret
    String accessTokenSecret = "luF2CzgnRLmpNhK5snVJn6FvsQcwMeaOuQXTO5la8KKz1";

    //Instantiate a re-usable and thread-safe factory
    TwitterFactory twitterFactory = new TwitterFactory();

    //Instantiate a new Twitter instance
    Twitter twitter = twitterFactory.getInstance();
    

    
    /**
     * Creates new form twitter
     */
    public twitter() {
        initComponents();
        setKey();
    }
    
    public void setKey(){
        //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);

        //setup OAuth Access Token
        twitter.setOAuthAccessToken(
                new AccessToken(accessToken, accessTokenSecret));
    
    
}
    
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
    
    public void paintComponent(Graphics g){
        //updateTweets();
    }

    public void startTwitterTimer(){
        tweetRefresh.start();
    }
   

    public void updateTweets() {
        

        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline:");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" + status.getText());
            }
            //TweetTextArea.

            //Instantiate and initialize a new twitter status update
            //StatusUpdate statusUpdate = new StatusUpdate("NHS Display's First Tweet!");
            //+ " - http://h1b-work-visa-usa.blogspot.com/2013/07/h-1b-transfer-jobs-java-developer_19.html");
            //attach any media, if you want to
            /*
             statusUpdate.setMedia(
             //title of media
             "http://h1b-work-visa-usa.blogspot.com", new URL("http://lh6.ggpht.com/-NiYLR6SkOmc/Uen_M8CpB7I/AAAAAAAAEQ8/tO7fufmK0Zg/h-1b%252520transfer%252520jobs%25255B4%25255D.png?imgmax=800").openStream());
            
             //tweet or update status
             Status status = twitter.updateStatus(statusUpdate);
            
             //response from twitter server
             System.out.println("status.toString() = " + status.toString());
             System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
             System.out.println("status.getSource() = " + status.getSource());
             System.out.println("status.getText() = " + status.getText());
             System.out.println("status.getContributors() = " + Arrays.toString(status.getContributors()));
             System.out.println("status.getCreatedAt() = " + status.getCreatedAt());
             System.out.println("status.getCurrentUserRetweetId() = " + status.getCurrentUserRetweetId());
             System.out.println("status.getGeoLocation() = " + status.getGeoLocation());
             System.out.println("status.getId() = " + status.getId());
             System.out.println("status.getInReplyToStatusId() = " + status.getInReplyToStatusId());
             System.out.println("status.getInReplyToUserId() = " + status.getInReplyToUserId());
             System.out.println("status.getPlace() = " + status.getPlace());
             System.out.println("status.getRetweetCount() = " + status.getRetweetCount());
             System.out.println("status.getRetweetedStatus() = " + status.getRetweetedStatus());
             System.out.println("status.getUser() = " + status.getUser());
             System.out.println("status.getAccessLevel() = " + status.getAccessLevel());
             System.out.println("status.getHashtagEntities() = " + Arrays.toString(status.getHashtagEntities()));
             System.out.println("status.getMediaEntities() = " + Arrays.toString(status.getMediaEntities()));
             if (status.getRateLimitStatus() != null) {
             System.out.println("status.getRateLimitStatus().getLimit() = " + status.getRateLimitStatus().getLimit());
             System.out.println("status.getRateLimitStatus().getRemaining() = " + status.getRateLimitStatus().getRemaining());
             System.out.println("status.getRateLimitStatus().getResetTimeInSeconds() = " + status.getRateLimitStatus().getResetTimeInSeconds());
             System.out.println("status.getRateLimitStatus().getSecondsUntilReset() = " + status.getRateLimitStatus().getSecondsUntilReset());
             //  System.out.println("status.getRateLimitStatus().getRemainingHits() = " + status.getRateLimitStatus().getRemainingHits());
             }
             System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
             System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
            
             }catch(TwitterException e){
            
             }
             */
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(TwitterJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
