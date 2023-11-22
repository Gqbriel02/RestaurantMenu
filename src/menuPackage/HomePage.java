package menuPackage;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;
import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.awt.*;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	Set<Starter> starters = new HashSet<Starter>();
	Set<MainDish> mainDishes = new HashSet<MainDish>();
	Set<Dessert> desserts = new HashSet<Dessert>();
	Set<Drinks> drinks = new HashSet<Drinks>();
	
	Set<Integer> ids = new HashSet<Integer>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		super("Restaurant Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.ORANGE);

		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainTabbedPane.setPreferredSize(new Dimension(550, 300));
		contentPane.add(mainTabbedPane);
		mainTabbedPane.setBackground(Color.YELLOW);

		// START - starterPanel
		JPanel starterPanel = new JPanel();
		starterPanel.setBackground(Color.ORANGE);

		JTabbedPane starterTabbedPane = new JTabbedPane();
		starterTabbedPane.setBackground(Color.YELLOW);
		starterPanel.setSize(590, 390);
		starterPanel.add(starterTabbedPane);
		starterTabbedPane.setPreferredSize(new Dimension(500, 250));

		JPanel addStarterPanel = new JPanel(new GridLayout(6, 2));
		addStarterPanel.setBackground(Color.ORANGE);
		starterTabbedPane.addTab("Add Starter", addStarterPanel);

		DefaultTableModel starterTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Details", "Price", "Type" });
		JTable starterTable = new JTable(starterTableModel);
		JScrollPane starterScrollPane = new JScrollPane(starterTable);
		starterTabbedPane.addTab("Show Starters", starterScrollPane);
		starterTable.setBackground(Color.YELLOW);

		JLabel id1Label = new JLabel("ID:");
		JLabel name1Label = new JLabel("Name:");
		JLabel details1Label = new JLabel("Details:");
		JLabel price1Label = new JLabel("Price:");
		JLabel starterTypeLabel = new JLabel("Type:");

		JTextField id1TF = new JTextField();
		JTextField name1TF = new JTextField();
		JTextField details1TF = new JTextField();
		JTextField price1TF = new JTextField();
		JTextField starterTypeTF = new JTextField();

		id1TF.setPreferredSize(new Dimension(50, 10));
		name1TF.setPreferredSize(new Dimension(50, 10));
		details1TF.setPreferredSize(new Dimension(50, 10));
		price1TF.setPreferredSize(new Dimension(50, 10));
		starterTypeLabel.setPreferredSize(new Dimension(50, 10));

		addStarterPanel.add(id1Label);
		addStarterPanel.add(id1TF);
		addStarterPanel.add(name1Label);
		addStarterPanel.add(name1TF);
		addStarterPanel.add(details1Label);
		addStarterPanel.add(details1TF);
		addStarterPanel.add(price1Label);
		addStarterPanel.add(price1TF);
		addStarterPanel.add(starterTypeLabel);
		addStarterPanel.add(starterTypeTF);

		JButton addStarterButton = new JButton("Add Starter");
		addStarterButton.setBackground(Color.YELLOW);
		addStarterButton.addActionListener(actionEvent -> {
			String idText = id1TF.getText().trim();
			String name = name1TF.getText().trim();
			String details = details1TF.getText().trim();
			String priceText = price1TF.getText().trim();
			String starterType = starterTypeTF.getText().trim();

			if (idText.isEmpty() || name.isEmpty() || details.isEmpty() || priceText.isEmpty()
					|| starterType.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please complete all the fields.");
				return;
			}

			int id;
			double price;
			try {
				id = Integer.parseInt(idText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for ID.");
				return;
			}

			try {
				price = Double.parseDouble(priceText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for price.");
				return;
			}

			if (ids.contains(id)) {
				JOptionPane.showMessageDialog(null, "ID already exists. Insert another one.");
				return;
			}
			ids.add(id);

			Starter starterTest = new Starter(id, name, details, price, starterType);
			id1TF.setText("");
			name1TF.setText("");
			details1TF.setText("");
			price1TF.setText("");
			starterTypeTF.setText("");

			Object[] row = { id, name, details, price, starterType };
			starterTableModel.addRow(row);
			starters.add(starterTest);
		});
		addStarterPanel.add(addStarterButton);
		mainTabbedPane.addTab("Starters", starterPanel);
		starterPanel.setLayout(new BorderLayout());
		starterPanel.add(starterTabbedPane, BorderLayout.CENTER);
		// END - starterPanel

		// START - mainDishPanel
		JPanel mainDishPanel = new JPanel();
		mainDishPanel.setBackground(Color.ORANGE);
		mainTabbedPane.addTab("Main Dish", mainDishPanel);
		mainDishPanel.setLayout(null);

		JTabbedPane mainDishTabbedPane = new JTabbedPane();
		mainDishTabbedPane.setBackground(Color.YELLOW);
		mainDishPanel.setSize(590, 390);
		mainDishPanel.add(mainDishTabbedPane);
		mainDishTabbedPane.setPreferredSize(new Dimension(500, 250));

		JPanel addMainDishPanel = new JPanel(new GridLayout(6, 2));
		mainDishTabbedPane.addTab("Add Main Dish", addMainDishPanel);
		addMainDishPanel.setBackground(Color.ORANGE);

		DefaultTableModel mainDishTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Details", "Price", "Cuisine" });
		JTable mainDishTable = new JTable(mainDishTableModel);
		mainDishTable.setBackground(Color.YELLOW);
		JScrollPane mainDishScrollPane = new JScrollPane(mainDishTable);
		mainDishTabbedPane.addTab("Show Main Dishes", mainDishScrollPane);

		JLabel id2Label = new JLabel("ID:");
		JLabel name2Label = new JLabel("Name:");
		JLabel details2Label = new JLabel("Details:");
		JLabel price2Label = new JLabel("Price:");
		JLabel cuisineLabel = new JLabel("Cuisine:");

		JTextField id2TF = new JTextField();
		JTextField name2TF = new JTextField();
		JTextField details2TF = new JTextField();
		JTextField price2TF = new JTextField();
		JTextField cuisineTF = new JTextField();

		id2TF.setPreferredSize(new Dimension(50, 10));
		name2TF.setPreferredSize(new Dimension(50, 10));
		details2TF.setPreferredSize(new Dimension(50, 10));
		price2TF.setPreferredSize(new Dimension(50, 10));
		cuisineTF.setPreferredSize(new Dimension(50, 10));

		addMainDishPanel.add(id2Label);
		addMainDishPanel.add(id2TF);
		addMainDishPanel.add(name2Label);
		addMainDishPanel.add(name2TF);
		addMainDishPanel.add(details2Label);
		addMainDishPanel.add(details2TF);
		addMainDishPanel.add(price2Label);
		addMainDishPanel.add(price2TF);
		addMainDishPanel.add(cuisineLabel);
		addMainDishPanel.add(cuisineTF);

		JButton addMainDishButton = new JButton("Add Main Dish");
		addMainDishButton.setBackground(Color.YELLOW);
		addMainDishButton.addActionListener(actionEvent -> {
			String idText = id2TF.getText().trim();
			String name = name2TF.getText().trim();
			String details = details2TF.getText().trim();
			String priceText = price2TF.getText().trim();
			String cuisine = cuisineTF.getText();

			if (idText.isEmpty() || name.isEmpty() || details.isEmpty() || priceText.isEmpty() || cuisine.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please complete all the fields.");
				return;
			}

			int id;
			double price;
			try {
				id = Integer.parseInt(idText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for ID.");
				return;
			}

			try {
				price = Double.parseDouble(priceText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for price.");
				return;
			}

			if (ids.contains(id)) {
				JOptionPane.showMessageDialog(null, "ID already exists. Insert another one.");
				return;
			}
			ids.add(id);

			MainDish mainDishTest = new MainDish(id, name, details, price, cuisine);
			id2TF.setText("");
			name2TF.setText("");
			details2TF.setText("");
			price2TF.setText("");
			cuisineTF.setText("");

			Object[] row = { id, name, details, price, cuisine };
			mainDishTableModel.addRow(row);
			mainDishes.add(mainDishTest);
		});
		addMainDishPanel.add(addMainDishButton);
		mainTabbedPane.addTab("Main Dishes", mainDishPanel);
		mainDishPanel.setLayout(new BorderLayout());
		mainDishPanel.add(mainDishTabbedPane, BorderLayout.CENTER);
		// END - mainDishPanel

		// START - dessertPanel
		JPanel dessertPanel = new JPanel();
		dessertPanel.setBackground(Color.ORANGE);
		mainTabbedPane.addTab("Dessert", dessertPanel);

		JTabbedPane dessertTabbedPane = new JTabbedPane();
		dessertTabbedPane.setBackground(Color.YELLOW);
		dessertPanel.setSize(590, 390);
		dessertPanel.add(dessertTabbedPane);
		dessertTabbedPane.setPreferredSize(new Dimension(500, 250));

		JPanel addDessertPanel = new JPanel(new GridLayout(6, 2));
		addDessertPanel.setBackground(Color.ORANGE);
		dessertTabbedPane.addTab("Add Dessert", addDessertPanel);

		DefaultTableModel dessertTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Details", "Price", "Type" });

		JTable dessertTable = new JTable(dessertTableModel);
		dessertTable.setBackground(Color.YELLOW);
		JScrollPane dessertScrollPane = new JScrollPane(dessertTable);
		dessertTabbedPane.addTab("Show Desserts", dessertScrollPane);

		JLabel id3Label = new JLabel("ID:");
		JLabel name3Label = new JLabel("Name:");
		JLabel details3Label = new JLabel("Details:");
		JLabel price3Label = new JLabel("Price:");
		JLabel dessertTypeLabel = new JLabel("Type:");

		JTextField id3TF = new JTextField();
		JTextField name3TF = new JTextField();
		JTextField details3TF = new JTextField();
		JTextField price3TF = new JTextField();

		String[] dessertTypes = { "Choose a type", "Vegan", "Non-Vegan", "Gluten-free", "Low-sugar" };
		// JComboBox<String> dessertTypeCB = new JComboBox<String>(dessertTypes);
		JComboBox<String> dessertTypeCB = new JComboBox<String>(dessertTypes);

		// String[] dessertTypes = {"Choose a type", "Vegan", "Non-Vegan",
		// "Gluten-free", "Low-sugar"};
		// DefaultComboBoxModel<String> comboModel = new
		// DefaultComboBoxModel<String>(dessertTypes);
		// JComboBox desertTypeCB = new JComboBox(comboModel);`

		id3TF.setPreferredSize(new Dimension(50, 10));
		name3TF.setPreferredSize(new Dimension(50, 10));
		details3TF.setPreferredSize(new Dimension(50, 10));
		price3TF.setPreferredSize(new Dimension(50, 10));
		dessertTypeCB.setPreferredSize(new Dimension(50, 10));

		addDessertPanel.add(id3Label);
		addDessertPanel.add(id3TF);
		addDessertPanel.add(name3Label);
		addDessertPanel.add(name3TF);
		addDessertPanel.add(details3Label);
		addDessertPanel.add(details3TF);
		addDessertPanel.add(price3Label);
		addDessertPanel.add(price3TF);
		addDessertPanel.add(dessertTypeLabel);
		addDessertPanel.add(dessertTypeCB);

		JButton addDessertButton = new JButton("Add Dessert");
		addDessertButton.setBackground(Color.YELLOW);
		addDessertButton.addActionListener(actionEvent -> {
			String idText = id3TF.getText().trim();
			String name = name3TF.getText().trim();
			String details = details3TF.getText().trim();
			String priceText = price3TF.getText().trim();
			String dessertType = (String) dessertTypeCB.getSelectedItem();

			if (idText.isEmpty() || name.isEmpty() || details.isEmpty() || priceText.isEmpty()
					|| dessertType.equals("Choose a type")) {
				JOptionPane.showMessageDialog(null, "Please complete all the fields.");
				return;
			}

			int id;
			double price;
			try {
				id = Integer.parseInt(idText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for ID.");
				return;
			}

			try {
				price = Double.parseDouble(priceText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for price.");
				return;
			}

			if (ids.contains(id)) {
				JOptionPane.showMessageDialog(null, "ID already exists. Insert another one.");
				return;
			}
			ids.add(id);

			Dessert dessertTest = new Dessert(id, name, details, price, dessertType);

			id3TF.setText("");
			name3TF.setText("");
			details3TF.setText("");
			price3TF.setText("");
			dessertTypeCB.setSelectedItem("Choose a type");

			Object[] row = { id, name, details, price, dessertType };
			dessertTableModel.addRow(row);
			desserts.add(dessertTest);
		});

		addDessertPanel.add(addDessertButton);
		mainTabbedPane.addTab("Desserts", dessertPanel);
		dessertPanel.setLayout(new BorderLayout());
		dessertPanel.add(dessertTabbedPane, BorderLayout.CENTER);
		// END - dessertPanel

		// START - drinksPanel
		JPanel drinksPanel = new JPanel();
		drinksPanel.setBackground(Color.ORANGE);
		mainTabbedPane.addTab("Drinks", drinksPanel);
		drinksPanel.setLayout(null);

		JTabbedPane drinksTabbedPane = new JTabbedPane();
		drinksTabbedPane.setBackground(Color.YELLOW);
		drinksPanel.setSize(590, 390);
		drinksPanel.add(drinksTabbedPane);
		drinksTabbedPane.setPreferredSize(new Dimension(500, 250));

		JPanel addDrinksPanel = new JPanel(new GridLayout(6, 2));
		addDrinksPanel.setBackground(Color.ORANGE);
		drinksTabbedPane.addTab("Add Drink", addDrinksPanel);

		DefaultTableModel drinksTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Details", "Price", "Type" });
		JTable drinksTable = new JTable(drinksTableModel);
		drinksTable.setBackground(Color.YELLOW);
		JScrollPane drinksScrollPane = new JScrollPane(drinksTable);
		drinksTabbedPane.addTab("Show Drinks", drinksScrollPane);

		JLabel id4Label = new JLabel("ID:");
		JLabel name4Label = new JLabel("Name:");
		JLabel details4Label = new JLabel("Details:");
		JLabel price4Label = new JLabel("Price:");
		JLabel drinksTypeLabel = new JLabel("Type:");

		JTextField id4TF = new JTextField();
		JTextField name4TF = new JTextField();
		JTextField details4TF = new JTextField();
		JTextField price4TF = new JTextField();
		String[] drinkTypes = { "Choose a type", "Alcoholic", "Non-Alcoholic" };
		JComboBox<String> drinksTypeCB = new JComboBox<>(drinkTypes);

		id4TF.setPreferredSize(new Dimension(50, 10));
		name4TF.setPreferredSize(new Dimension(50, 10));
		details4TF.setPreferredSize(new Dimension(50, 10));
		price4TF.setPreferredSize(new Dimension(50, 10));
		drinksTypeCB.setPreferredSize(new Dimension(50, 10));

		addDrinksPanel.add(id4Label);
		addDrinksPanel.add(id4TF);
		addDrinksPanel.add(name4Label);
		addDrinksPanel.add(name4TF);
		addDrinksPanel.add(details4Label);
		addDrinksPanel.add(details4TF);
		addDrinksPanel.add(price4Label);
		addDrinksPanel.add(price4TF);
		addDrinksPanel.add(drinksTypeLabel);
		addDrinksPanel.add(drinksTypeCB);

		JButton addDrinksButton = new JButton("Add Drink");
		addDrinksButton.setBackground(Color.YELLOW);
		addDrinksButton.addActionListener(actionEvent -> {
			String idText = id4TF.getText().trim();
			String name = name4TF.getText().trim();
			String details = details4TF.getText().trim();
			String priceText = price4TF.getText().trim();
			String drinksType = (String) drinksTypeCB.getSelectedItem();

			if (idText.isEmpty() || name.isEmpty() || details.isEmpty() || priceText.isEmpty()
					|| drinksType.equals("Choose a type")) {
				JOptionPane.showMessageDialog(null, "Please complete all the fields.");
				return;
			}

			int id;
			double price;
			try {
				id = Integer.parseInt(idText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for ID.");
				return;
			}

			try {
				price = Double.parseDouble(priceText);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number for price.");
				return;
			}

			if (ids.contains(id)) {
				JOptionPane.showMessageDialog(null, "ID already exists. Insert another one.");
				return;
			}
			ids.add(id);

			Drinks drinksTest = new Drinks(id, name, details, price, drinksType);

			id4TF.setText("");
			name4TF.setText("");
			details4TF.setText("");
			price4TF.setText("");
			drinksTypeCB.setSelectedItem("Choose a type");

			Object[] row = { id, name, details, price, drinksType };
			drinksTableModel.addRow(row);
			drinks.add(drinksTest);
		});

		addDrinksPanel.add(addDrinksButton);
		mainTabbedPane.addTab("Drinks", drinksPanel);
		drinksPanel.setLayout(new BorderLayout());
		drinksPanel.add(drinksTabbedPane, BorderLayout.CENTER);
		// END - drinksPanel

		// START - searchPanel by ID
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.ORANGE);

		JTabbedPane searchTabbedPane = new JTabbedPane();
		searchTabbedPane.setSize(590, 390);
		searchPanel.add(searchTabbedPane);
		searchTabbedPane.setPreferredSize(new Dimension(580, 380));

		JPanel searchByIdPanel = new JPanel(new GridLayout(2, 1));
		searchByIdPanel.setBackground(Color.YELLOW);
		searchByIdPanel.setAutoscrolls(true);
		searchTabbedPane.addTab("Search by ID", searchByIdPanel);

		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.setBackground(Color.ORANGE);
		JLabel searchLabel = new JLabel("ID:");
		JTextField searchTF = new JTextField();
		JButton searchButton = new JButton("Search");
		searchLabel.setPreferredSize(new Dimension(170, 50));
		searchTF.setPreferredSize(new Dimension(190, 50));
		searchButton.setPreferredSize(new Dimension(180, 50));

		topPanel.add(searchLabel);
		topPanel.add(searchTF);
		topPanel.add(searchButton);

		JPanel bottomPanel = new JPanel(new GridLayout(1, 1));

		DefaultTableModel searchTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Details", "Price", "Type / Cuisine" });
		JTable searchTable = new JTable(searchTableModel);
		searchTable.setBackground(Color.YELLOW);
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		bottomPanel.add(searchScrollPane);

		searchButton.setBackground(Color.YELLOW);
		searchButton.addActionListener(actionEvent -> {
			String idText = searchTF.getText();
			if (idText.isEmpty()) {
				String message = "Please enter an ID to search.";
				JOptionPane.showMessageDialog(searchPanel, message, "Search Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			int id;
			try {
				id = Integer.parseInt(idText);
			} catch (NumberFormatException e) {
				String message = "Please enter a valid ID to search.";
				JOptionPane.showMessageDialog(searchPanel, message, "Search Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			searchTableModel.setRowCount(0); 

			boolean found = false;

			/*
			Iterator<Menu> myIterator = allItems.iterator();
			while (myIterator.hasNext()) {
				Menu a = myIterator.next();
				if (a.getId() == id) {
					Object[] row = new Object[] { a.getId(), a.getName(), a.getDetails(), a.getPrice(),
							a.getStarterType() };
					searchTableModel.addRow(row);
					found = true;
				}
			} */
			
			
			Iterator<Starter> starterIterator = starters.iterator();
			while (starterIterator.hasNext()) {
				Starter a = starterIterator.next();
				if (a.getId() == id) {
					Object[] row = new Object[] { a.getId(), a.getName(), a.getDetails(), a.getPrice(),
							a.getStarterType() };
					searchTableModel.addRow(row);
					found = true;
				}
			}

			Iterator<MainDish> mainDishIterator = mainDishes.iterator();
			while (mainDishIterator.hasNext()) {
				MainDish b = mainDishIterator.next();
				if (b.getId() == id) {
					Object[] row = new Object[] { b.getId(), b.getName(), b.getDetails(), b.getPrice(),
							b.getCuisine() };
					searchTableModel.addRow(row);
					found = true;
				}
			}

			Iterator<Dessert> dessertsIterator = desserts.iterator();
			while (dessertsIterator.hasNext()) {
				Dessert c = dessertsIterator.next();
				if (c.getId() == id) {
					Object[] row = new Object[] { c.getId(), c.getName(), c.getDetails(), c.getPrice(),
							c.getDessertType() };
					searchTableModel.addRow(row);
					found = true;
				}
			}

			Iterator<Drinks> drinksIterator = drinks.iterator();
			while (drinksIterator.hasNext()) {
				Drinks d = drinksIterator.next();
				if (d.getId() == id) {
					Object[] row = new Object[] { d.getId(), d.getName(), d.getDetails(), d.getPrice(),
							d.getDrinksType() };
					searchTableModel.addRow(row);
					found = true;
				}
			} 

			if (!found) {
				String message = "No items found for the entered ID.";
				JOptionPane.showMessageDialog(searchPanel, message, "Search Result", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		topPanel.setPreferredSize(new Dimension(580, 100));
		bottomPanel.setPreferredSize(new Dimension(580, 280));
		searchByIdPanel.add(topPanel, BorderLayout.NORTH);
		searchByIdPanel.add(bottomPanel, BorderLayout.SOUTH);

		mainTabbedPane.addTab("Search", searchPanel);
		searchPanel.setLayout(new BorderLayout());
		searchPanel.add(searchTabbedPane, BorderLayout.CENTER);
		// END - Search Panel by Id

		// START - Search Panel by Price
		JPanel searchByPricePanel = new JPanel(new GridLayout(2, 1));
		searchByPricePanel.setBackground(Color.ORANGE);

		searchTabbedPane.setSize(590, 390);
		searchTabbedPane.setBackground(Color.YELLOW);
		searchPanel.add(searchByPricePanel);
		searchTabbedPane.setPreferredSize(new Dimension(580, 380));
		searchByPricePanel.setAutoscrolls(true);
		searchTabbedPane.addTab("Search by Price", searchByPricePanel);

		JPanel topPanel1 = new JPanel(new FlowLayout());
		topPanel1.setBackground(Color.ORANGE);
		JLabel searchLabel1 = new JLabel("Price:");
		JTextField searchTF1 = new JTextField();
		JButton searchButton1 = new JButton("Search");
		searchLabel1.setPreferredSize(new Dimension(170, 50));
		searchTF1.setPreferredSize(new Dimension(190, 50));
		searchButton1.setPreferredSize(new Dimension(180, 50));

		topPanel1.add(searchLabel1);
		topPanel1.add(searchTF1);
		topPanel1.add(searchButton1);

		JPanel bottomPanel1 = new JPanel(new GridLayout(1, 1));

		DefaultTableModel searchTableModel1 = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Details", "Price", "Type / Cuisine" });
		JTable searchTable1 = new JTable(searchTableModel1);
		searchTable1.setBackground(Color.YELLOW);
		JScrollPane searchScrollPane1 = new JScrollPane(searchTable1);
		bottomPanel1.add(searchScrollPane1);

		searchButton1.setBackground(Color.YELLOW);
		searchButton1.addActionListener(actionEvent -> {
			String priceText = searchTF1.getText();
			if (priceText.isEmpty()) {
				String message = "Please enter a price to search.";
				JOptionPane.showMessageDialog(searchPanel, message, "Search Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			double price;
			try {
				price = Double.parseDouble(priceText);
			} catch (NumberFormatException e) {
				String message = "Please enter a valid price to search.";
				JOptionPane.showMessageDialog(searchPanel, message, "Search Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			searchTableModel1.setRowCount(0); // clear previous rows

			boolean found = false;

			Iterator<Starter> starterIterator = starters.iterator();
			while (starterIterator.hasNext()) {
				Starter a = starterIterator.next();
				if (a.getPrice() == price) {
					Object[] row = new Object[] { a.getId(), a.getName(), a.getDetails(), a.getPrice(),
							a.getStarterType() };
					searchTableModel1.addRow(row);
					found = true;
				}
			}

			Iterator<MainDish> mainDishIterator = mainDishes.iterator();
			while (mainDishIterator.hasNext()) {
				MainDish b = mainDishIterator.next();
				if (b.getPrice() == price) {
					Object[] row = new Object[] { b.getId(), b.getName(), b.getDetails(), b.getPrice(),
							b.getCuisine() };
					searchTableModel1.addRow(row);
					found = true;
				}
			}

			Iterator<Dessert> dessertsIterator = desserts.iterator();
			while (dessertsIterator.hasNext()) {
				Dessert c = dessertsIterator.next();
				if (c.getPrice() == price) {
					Object[] row = new Object[] { c.getId(), c.getName(), c.getDetails(), c.getPrice(),
							c.getDessertType() };
					searchTableModel1.addRow(row);
					found = true;
				}
			}

			Iterator<Drinks> drinksIterator = drinks.iterator();
			while (drinksIterator.hasNext()) {
				Drinks d = drinksIterator.next();
				if (d.getPrice() == price) {
					Object[] row = new Object[] { d.getId(), d.getName(), d.getDetails(), d.getPrice(),
							d.getDrinksType() };
					searchTableModel1.addRow(row);
					found = true;
				}
			}

			if (!found) {
				String message = "No items found for the entered price.";
				JOptionPane.showMessageDialog(searchPanel, message, "Search Result", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		topPanel1.setPreferredSize(new Dimension(580, 100));
		bottomPanel1.setPreferredSize(new Dimension(580, 280));
		searchByPricePanel.add(topPanel1, BorderLayout.NORTH);
		searchByPricePanel.add(bottomPanel1, BorderLayout.SOUTH);

		mainTabbedPane.addTab("Search", searchPanel);
		searchPanel.setLayout(new BorderLayout());
		searchPanel.add(searchTabbedPane, BorderLayout.CENTER);
		// END - Search Panel by Price

		setContentPane(contentPane);
	}
}
