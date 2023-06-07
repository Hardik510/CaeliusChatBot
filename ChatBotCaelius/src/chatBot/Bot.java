package chatBot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.time.LocalTime;

import java.net.URL;
import java.net.URLConnection;

class Bott extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// making the GUI
	private JTextArea chatarea = new JTextArea();
	private JTextField chatbox = new JTextField();
	public  Bott() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(525, 485);
		frame.setTitle("Caelius ChatBot");
		frame.add(chatarea);
		frame.add(chatbox);
		chatarea.setEditable(false);
		chatarea.setLineWrap(true);
		chatarea.setWrapStyleWord(true);
		
		chatarea.setSize(500, 400);
		chatarea.setLocation(5, 5);
		
		chatbox.setSize(500, 30);
		chatbox.setLocation(5, 410);
		
		// chat area gets scrollbar when needed
		JScrollPane scrollPane = new JScrollPane(chatarea);
        scrollPane.setBounds(5, 5, 500, 400);
        frame.add(scrollPane);
		
        // welcome message
		chatarea.append("Bot: " + "Hey there! Welcome to ChatBot made by Hardik Chopra as a project for Caelius Consulting pvt. ltd.\n");
		chatarea.append("Bot: " + "You can ask general questions, questions related to JAVA programming language, or anything else.\n");
		chatarea.append("Bot: " + "I would be happy to answer you\n");
		chatarea.append("Bot: " + "For some sample questions, ask 'what can you do?'\n\n");
		
		chatbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String inputString = chatbox.getText();
				chatarea.append("You: " + inputString + "\n");
				chatbox.setText("");
				LocalTime time = LocalTime.now();
				LocalDate date = LocalDate.now();
				boolean answered = false;
				
				// to parse json array
				Gson gson = new Gson();
				JsonArray jsonArray = null;
				try (FileReader reader = new FileReader("./resources/chatbotQNA.json")) {
				    // Parse the JSON file
				    JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
				    jsonArray = jsonElement.getAsJsonArray();
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
				if(inputString.toLowerCase().equals("hi") || inputString.toLowerCase().equals("hello")) {
					botReply("Hello! How can I help you?");
					answered = true;
				}
				else if(inputString.toLowerCase().contains("how are you?")) {
					botReply("I am good. How can I assist you today?");
					answered = true;
				}
				else if(inputString.toLowerCase().contains("what can you do?")) {
					botReply("You can ask questions like:"
							+ "\n What is the time?"
							+ "\n What is the date?"
							+ "\n clear screen");
					answered = true;
				}
				else if(inputString.toLowerCase().contains("ok")||inputString.toLowerCase().contains("okay")) {
					botReply("Is there anything else I can help you with?");
					answered = true;
				}
				else if( inputString.contains("time"))
				{
				
					String time12=new String();
					if(time.getHour()>12)
					{
						int hour=time.getHour()-12;
						time12 = time12 + hour + ":" + time.getMinute() + " PM";
					}
					
					else
					{
						int hour = time.getHour();
						if(hour == 0) {
							hour = 12;
						}
						time12 = time12 + hour + ":" + time.getMinute() + " AM";
					}
					botReply(time12);
					answered = true;
				}
				else if(inputString.contains("date")||inputString.contains("month")||inputString.contains("year")||inputString.contains("day"))
				{
				
					String dateFinal = new String();
					dateFinal = dateFinal + date.getDayOfWeek() + "," + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
					botReply(dateFinal);
					answered = true;
					
					
				}
				else if(inputString.contains("clear")&&(inputString.contains("screen")||inputString.contains("chat")))
				{
					chatarea.setText("");
					answered = true;
				}
				else{
					//search for question in database
					for (JsonElement element : jsonArray) {
				        JsonObject entry = element.getAsJsonObject();
				        String question = entry.get("question").getAsString();

				        if (question.equals(inputString)) {
				            String answer = entry.get("answer").getAsString();
				            botReply(answer);
				            answered = true;
				            break;
				        }
				    }
				}
				if(!answered) // if answer not found in database
				{
					try
					{
						try
						{
							// search google
							URL url=new URL("https://google.co.in");
							URLConnection connection=url.openConnection();
							connection.connect();
							botReply("Here's what I found on the web...");
							java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.google.com/search?hl=en&q="+inputString.replace(" ", "+")+"&btnG=Google+Search"));
					
						}
						catch(Exception ee)
						{
							botReply("No Internet connection...");
						}
						
					}
					catch(Exception eee)
					{
						botReply("Invalid Input.");
					}
				}
			}
		});
	}
	private void botReply(String str) {
		chatarea.append("Bot: " + str + "\n");
	}
	
}


public class Bot {

	public static void main(String[] args) {
		new Bott();
	}

}
