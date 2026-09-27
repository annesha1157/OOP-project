import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrafficSystemGUI extends JFrame {

    private TrafficController controller;

    private int accountCounter = 0;
    private int vehicleCounter = 0;
    private int requestCounter = 0;
    private int crossingCounter = 0;

    // Stores registered vehicle numbers
    private Set<String> registeredVehicles = new HashSet<>();

    private JTextArea outputArea;

    // =========================================================
    // PASSENGER
    // =========================================================

    private JTextField paxNameField;
    private JTextField paxPhoneField;
    private JTextField paxLocationField;
    private JTextField paxIdField;
    private JTextField paxPeopleField;

    // =========================================================
    // VEHICLE
    // =========================================================

    private JTextField vehNameField;
    private JTextField vehPhoneField;
    private JTextField vehNumberField;

    private JComboBox<String> vehTypeBox;

    // =========================================================
    // POLICE / JUNCTION
    // =========================================================

    private JTextField policeNameField;
    private JTextField policePhoneField;
    private JTextField policeIdField;
    private JTextField policeLocationField;

    private JTextField junctionIdField;
    private JTextField junctionLocationField;

    private JTextField clearanceJunctionIdField;
    private JTextField clearanceOfficerField;

    // =========================================================
    // EMERGENCY REQUEST
    // =========================================================

    private JTextField erVehicleNumberField;
    private JTextField erLocationField;
    private JTextField erDestinationField;
    private JTextField erReasonField;

    // Emergency Priority
    private JComboBox<String> emergencyPriorityBox;

    // Admin
    private JTextField erRequestIdField;

    // =========================================================
    // ROADMAP
    // =========================================================

    private JTextField routeFromField;
    private JTextField routeToField;
    private JTextField routeDistanceField;

    private JComboBox<String> routeDensityBox;
    private JCheckBox routeBlockedBox;

    private JTextField routeSourceField;
    private JTextField routeDestField;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public TrafficSystemGUI() {

        controller = new TrafficController();

        setTitle(
                "Smart Traffic Management & Emergency Response System"
        );

        setSize(900, 750);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));


        // =====================================================
        // TABS
        // =====================================================

        JTabbedPane tabs = new JTabbedPane();


        tabs.addTab(
                "Passenger / Crossing",
                buildPassengerTab()
        );


        tabs.addTab(
                "Vehicle / Priority",
                buildVehicleTab()
        );


        tabs.addTab(
                "Police / Junction",
                buildPoliceJunctionTab()
        );


        tabs.addTab(
                "Emergency Request",
                buildEmergencyTab()
        );


        tabs.addTab(
                "Roadmap / Rules",
                buildRoadmapTab()
        );


        // =====================================================
        // ADMIN SIDE
        // =====================================================

        tabs.addTab(
                "Admin Dashboard",
                buildAdminDashboard()
        );


        add(tabs, BorderLayout.CENTER);


        // =====================================================
        // OUTPUT AREA
        // =====================================================

        outputArea = new JTextArea();

        outputArea.setEditable(false);

        outputArea.setLineWrap(true);

        outputArea.setWrapStyleWord(true);

        outputArea.setText(
                "Welcome to Smart Traffic Management & "
                        + "Emergency Response System!\n\n"
                        + "Users can submit requests from the user tabs.\n"
                        + "Administrators can manage requests from "
                        + "the Admin Dashboard."
        );


        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "System Output"
                )
        );


        scrollPane.setPreferredSize(
                new Dimension(880, 220)
        );


        add(
                scrollPane,
                BorderLayout.SOUTH
        );


        setVisible(true);
    }


    // =========================================================
    // PASSENGER TAB
    // =========================================================

    private JPanel buildPassengerTab() {

        JPanel panel =
                new JPanel(new BorderLayout(5, 5));


        // -------------------------
        // Passenger Registration
        // -------------------------

        JPanel regPanel =
                new JPanel(
                        new GridLayout(4, 2, 5, 5)
                );


        regPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Passenger Registration"
                )
        );


        regPanel.add(
                new JLabel("Name:")
        );


        paxNameField =
                new JTextField();


        regPanel.add(
                paxNameField
        );


        regPanel.add(
                new JLabel("Phone:")
        );


        paxPhoneField =
                new JTextField();


        regPanel.add(
                paxPhoneField
        );


        regPanel.add(
                new JLabel("Location:")
        );


        paxLocationField =
                new JTextField();


        regPanel.add(
                paxLocationField
        );


        JButton registerPaxButton =
                new JButton(
                        "Register Passenger"
                );


        regPanel.add(
                new JLabel()
        );


        regPanel.add(
                registerPaxButton
        );


        registerPaxButton.addActionListener(
                e -> registerPassenger()
        );


        // -------------------------
        // Road Crossing Request
        // -------------------------

        JPanel crossPanel =
                new JPanel(
                        new GridLayout(3, 2, 5, 5)
                );


        crossPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Road Crossing Request"
                )
        );


        crossPanel.add(
                new JLabel("Passenger ID:")
        );


        paxIdField =
                new JTextField();


        crossPanel.add(
                paxIdField
        );


        crossPanel.add(
                new JLabel("Number of People:")
        );


        paxPeopleField =
                new JTextField();


        crossPanel.add(
                paxPeopleField
        );


        JButton requestCrossingButton =
                new JButton(
                        "Request Crossing"
                );


        crossPanel.add(
                new JLabel()
        );


        crossPanel.add(
                requestCrossingButton
        );


        requestCrossingButton.addActionListener(
                e -> requestCrossing()
        );


        JPanel top =
                new JPanel(
                        new GridLayout(2, 1, 5, 5)
                );


        top.add(regPanel);

        top.add(crossPanel);


        panel.add(
                top,
                BorderLayout.NORTH
        );


        return panel;
    }


    // =========================================================
    // VEHICLE TAB
    // =========================================================

    private JPanel buildVehicleTab() {

        JPanel panel =
                new JPanel(new BorderLayout(5, 5));


        // =====================================================
        // VEHICLE REGISTRATION
        // =====================================================

        JPanel vehiclePanel =
                new JPanel(
                        new GridLayout(4, 2, 5, 5)
                );


        vehiclePanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Vehicle Registration"
                )
        );


        vehiclePanel.add(
                new JLabel("Owner Name:")
        );


        vehNameField =
                new JTextField();


        vehiclePanel.add(
                vehNameField
        );


        vehiclePanel.add(
                new JLabel("Phone:")
        );


        vehPhoneField =
                new JTextField();


        vehiclePanel.add(
                vehPhoneField
        );


        vehiclePanel.add(
                new JLabel("Vehicle Number:")
        );


        vehNumberField =
                new JTextField();


        vehiclePanel.add(
                vehNumberField
        );


        vehiclePanel.add(
                new JLabel("Vehicle Type:")
        );


        vehTypeBox =
                new JComboBox<>(
                        new String[]{
                                "Car",
                                "Bus",
                                "Truck",
                                "Ambulance",
                                "Fire Service",
                                "Police",
                                "Motorcycle",
                                "Other"
                        }
                );


        vehiclePanel.add(
                vehTypeBox
        );


        // =====================================================
        // BUTTON PANEL
        // =====================================================

        JButton addVehicleButton =
                new JButton(
                        "Register Vehicle"
                );


        JButton priorityButton =
                new JButton(
                        "Priority List"
                );


        JButton rulesButton =
                new JButton(
                        "Traffic Rules"
                );


        /*
         * Buttons are aligned to the right side.
         */

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                8,
                                5
                        )
                );


        buttons.add(
                addVehicleButton
        );


        buttons.add(
                priorityButton
        );


        buttons.add(
                rulesButton
        );


        addVehicleButton.addActionListener(
                e -> addVehicle()
        );


        priorityButton.addActionListener(
                e -> showPriorityList()
        );


        rulesButton.addActionListener(
                e -> showTrafficRules()
        );


        JPanel top =
                new JPanel(
                        new BorderLayout()
                );


        top.add(
                vehiclePanel,
                BorderLayout.NORTH
        );


        top.add(
                buttons,
                BorderLayout.CENTER
        );


        panel.add(
                top,
                BorderLayout.NORTH
        );


        return panel;
    }


    // =========================================================
    // POLICE / JUNCTION TAB
    // =========================================================

    private JPanel buildPoliceJunctionTab() {

        JPanel panel =
                new JPanel(new BorderLayout(5, 5));


        // -------------------------
        // Police Registration
        // -------------------------

        JPanel policePanel =
                new JPanel(
                        new GridLayout(5, 2, 5, 5)
                );


        policePanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Police Registration"
                )
        );


        policePanel.add(
                new JLabel("Officer Name:")
        );


        policeNameField =
                new JTextField();


        policePanel.add(
                policeNameField
        );


        policePanel.add(
                new JLabel("Phone:")
        );


        policePhoneField =
                new JTextField();


        policePanel.add(
                policePhoneField
        );


        policePanel.add(
                new JLabel("Police ID:")
        );


        policeIdField =
                new JTextField();


        policePanel.add(
                policeIdField
        );


        policePanel.add(
                new JLabel("Location:")
        );


        policeLocationField =
                new JTextField();


        policePanel.add(
                policeLocationField
        );


        JButton registerPoliceButton =
                new JButton(
                        "Register Police"
                );


        policePanel.add(
                new JLabel()
        );


        policePanel.add(
                registerPoliceButton
        );


        registerPoliceButton.addActionListener(
                e -> registerPolice()
        );


        // -------------------------
        // Junction
        // -------------------------

        JPanel junctionPanel =
                new JPanel(
                        new GridLayout(3, 2, 5, 5)
                );


        junctionPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Junction Management"
                )
        );


        junctionPanel.add(
                new JLabel("Junction ID:")
        );


        junctionIdField =
                new JTextField();


        junctionPanel.add(
                junctionIdField
        );


        junctionPanel.add(
                new JLabel("Location:")
        );


        junctionLocationField =
                new JTextField();


        junctionPanel.add(
                junctionLocationField
        );


        JButton addJunctionButton =
                new JButton(
                        "Add Junction"
                );


        junctionPanel.add(
                new JLabel()
        );


        junctionPanel.add(
                addJunctionButton
        );


        addJunctionButton.addActionListener(
                e -> addJunction()
        );


        // -------------------------
        // Clearance Request
        // -------------------------

        JPanel clearancePanel =
                new JPanel(
                        new GridLayout(3, 2, 5, 5)
                );


        clearancePanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Junction Clearance Request"
                )
        );


        clearancePanel.add(
                new JLabel("Junction ID:")
        );


        clearanceJunctionIdField =
                new JTextField();


        clearancePanel.add(
                clearanceJunctionIdField
        );


        clearancePanel.add(
                new JLabel("Officer:")
        );


        clearanceOfficerField =
                new JTextField();


        clearancePanel.add(
                clearanceOfficerField
        );


        JButton requestClearanceBtn =
                new JButton(
                        "Request Clearance"
                );


        clearancePanel.add(
                new JLabel()
        );


        clearancePanel.add(
                requestClearanceBtn
        );


        requestClearanceBtn.addActionListener(
                e -> requestClearance()
        );


        JPanel top =
                new JPanel(
                        new GridLayout(3, 1, 5, 5)
                );


        top.add(policePanel);

        top.add(junctionPanel);

        top.add(clearancePanel);


        panel.add(
                top,
                BorderLayout.NORTH
        );


        return panel;
    }


    // =========================================================
    // EMERGENCY REQUEST TAB
    // =========================================================

    private JPanel buildEmergencyTab() {

        JPanel panel =
                new JPanel(new BorderLayout(5, 5));


        /*
         * Emergency request is separate from
         * vehicle registration.
         */

        JPanel createPanel =
                new JPanel(
                        new GridLayout(6, 2, 5, 5)
                );


        createPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Create Emergency Request"
                )
        );


        // =====================================================
        // REGISTERED VEHICLE
        // =====================================================

        createPanel.add(
                new JLabel("Registered Vehicle Number:")
        );


        erVehicleNumberField =
                new JTextField();


        createPanel.add(
                erVehicleNumberField
        );


        // =====================================================
        // CURRENT LOCATION
        // =====================================================

        createPanel.add(
                new JLabel("Current Location:")
        );


        erLocationField =
                new JTextField();


        createPanel.add(
                erLocationField
        );


        // =====================================================
        // DESTINATION
        // =====================================================

        createPanel.add(
                new JLabel("Destination:")
        );


        erDestinationField =
                new JTextField();


        createPanel.add(
                erDestinationField
        );


        // =====================================================
        // EMERGENCY REASON
        // =====================================================

        createPanel.add(
                new JLabel("Emergency Reason:")
        );


        erReasonField =
                new JTextField();


        createPanel.add(
                erReasonField
        );


        // =====================================================
        // EMERGENCY PRIORITY
        // =====================================================

        createPanel.add(
                new JLabel("Emergency Priority:")
        );


        emergencyPriorityBox =
                new JComboBox<>(
                        new String[]{
                                "High",
                                "Medium",
                                "Low"
                        }
                );


        createPanel.add(
                emergencyPriorityBox
        );


        // =====================================================
        // BUTTON
        // =====================================================

        JButton createRequestButton =
                new JButton(
                        "Create Emergency Request"
                );


        createPanel.add(
                new JLabel()
        );


        createPanel.add(
                createRequestButton
        );


        createRequestButton.addActionListener(
                e -> createEmergencyRequest()
        );


        panel.add(
                createPanel,
                BorderLayout.NORTH
        );


        // =====================================================
        // INFORMATION AREA
        // =====================================================

        JTextArea info =
                new JTextArea();


        info.setEditable(false);

        info.setLineWrap(true);

        info.setWrapStyleWord(true);


        info.setText(
                "Emergency Request Information\n\n"
                        + "1. The vehicle must be registered first.\n"
                        + "2. Any registered vehicle can make an emergency request.\n"
                        + "3. Select the appropriate Emergency Priority.\n"
                        + "4. Enter the vehicle's current location and destination.\n"
                        + "5. Enter the reason for the emergency.\n"
                        + "6. The request will remain pending until admin approval."
        );


        panel.add(
                new JScrollPane(info),
                BorderLayout.CENTER
        );


        return panel;
    }


    // =========================================================
    // ADMIN DASHBOARD
    // =========================================================

    private JPanel buildAdminDashboard() {

        JPanel panel =
                new JPanel(new BorderLayout(5, 5));


        // =====================================================
        // EMERGENCY REQUEST MANAGEMENT
        // =====================================================

        JPanel emergencyPanel =
                new JPanel(
                        new GridLayout(2, 2, 5, 5)
                );


        emergencyPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Emergency Request Management"
                )
        );


        emergencyPanel.add(
                new JLabel("Request ID:")
        );


        erRequestIdField =
                new JTextField();


        emergencyPanel.add(
                erRequestIdField
        );


        JPanel buttons =
                new JPanel(
                        new GridLayout(1, 3, 5, 5)
                );


        JButton approveButton =
                new JButton("Approve");


        JButton rejectButton =
                new JButton("Reject");


        JButton completeButton =
                new JButton("Complete");


        buttons.add(
                approveButton
        );


        buttons.add(
                rejectButton
        );


        buttons.add(
                completeButton
        );


        emergencyPanel.add(
                new JLabel()
        );


        emergencyPanel.add(
                buttons
        );


        approveButton.addActionListener(
                e -> handleEmergencyAction("APPROVE")
        );


        rejectButton.addActionListener(
                e -> handleEmergencyAction("REJECT")
        );


        completeButton.addActionListener(
                e -> handleEmergencyAction("COMPLETE")
        );


        // =====================================================
        // ADMIN INFORMATION
        // =====================================================

        JTextArea adminInfo =
                new JTextArea();


        adminInfo.setEditable(false);

        adminInfo.setLineWrap(true);

        adminInfo.setWrapStyleWord(true);


        adminInfo.setText(
                "ADMIN / TRAFFIC CONTROLLER DASHBOARD\n\n"
                        + "Only authorized administrators should use "
                        + "this section.\n\n"
                        + "Admin responsibilities:\n"
                        + "• Approve emergency requests\n"
                        + "• Reject invalid requests\n"
                        + "• Complete emergency requests\n"
                        + "• Manage traffic operations\n"
                        + "• Monitor system requests"
        );


        panel.add(
                emergencyPanel,
                BorderLayout.NORTH
        );


        panel.add(
                new JScrollPane(adminInfo),
                BorderLayout.CENTER
        );


        return panel;
    }


    // =========================================================
    // ROADMAP TAB
    // =========================================================

    private JPanel buildRoadmapTab() {

        JPanel panel =
                new JPanel(new BorderLayout(5, 5));


        JPanel routePanel =
                new JPanel(
                        new GridLayout(6, 2, 5, 5)
                );


        routePanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Route Information"
                )
        );


        routePanel.add(
                new JLabel("From:")
        );


        routeFromField =
                new JTextField();


        routePanel.add(
                routeFromField
        );


        routePanel.add(
                new JLabel("To:")
        );


        routeToField =
                new JTextField();


        routePanel.add(
                routeToField
        );


        routePanel.add(
                new JLabel("Distance:")
        );


        routeDistanceField =
                new JTextField();


        routePanel.add(
                routeDistanceField
        );


        routePanel.add(
                new JLabel("Traffic Density:")
        );


        routeDensityBox =
                new JComboBox<>(
                        new String[]{
                                "Low",
                                "Medium",
                                "High"
                        }
                );


        routePanel.add(
                routeDensityBox
        );


        routePanel.add(
                new JLabel("Road Blocked:")
        );


        routeBlockedBox =
                new JCheckBox();


        routePanel.add(
                routeBlockedBox
        );


        JButton addRouteButton =
                new JButton(
                        "Add Route"
                );


        routePanel.add(
                new JLabel()
        );


        routePanel.add(
                addRouteButton
        );


        addRouteButton.addActionListener(
                e -> addRoute()
        );


        // -------------------------
        // Find Route
        // -------------------------

        JPanel findPanel =
                new JPanel(
                        new GridLayout(3, 2, 5, 5)
                );


        findPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Find Route"
                )
        );


        findPanel.add(
                new JLabel("Source:")
        );


        routeSourceField =
                new JTextField();


        findPanel.add(
                routeSourceField
        );


        findPanel.add(
                new JLabel("Destination:")
        );


        routeDestField =
                new JTextField();


        findPanel.add(
                routeDestField
        );


        JButton findRouteButton =
                new JButton(
                        "Find Route"
                );


        findPanel.add(
                new JLabel()
        );


        findPanel.add(
                findRouteButton
        );


        findRouteButton.addActionListener(
                e -> findRoute()
        );


        JPanel top =
                new JPanel(
                        new GridLayout(2, 1, 5, 5)
                );


        top.add(
                routePanel
        );


        top.add(
                findPanel
        );


        panel.add(
                top,
                BorderLayout.NORTH
        );


        return panel;
    }


    // =========================================================
    // PASSENGER METHODS
    // =========================================================

    private void registerPassenger() {

        String name =
                paxNameField.getText().trim();


        String phone =
                paxPhoneField.getText().trim();


        String location =
                paxLocationField.getText().trim();


        if (name.isEmpty()
                || phone.isEmpty()
                || location.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all passenger information."
            );


            return;
        }


        accountCounter++;


        String id =
                "PAX" + accountCounter;


        outputArea.setText(
                "Passenger Registered Successfully!\n\n"
                        + "Passenger ID: " + id + "\n"
                        + "Name: " + name + "\n"
                        + "Phone: " + phone + "\n"
                        + "Location: " + location
        );
    }


    private void requestCrossing() {

        String passengerId =
                paxIdField.getText().trim();


        String people =
                paxPeopleField.getText().trim();


        if (passengerId.isEmpty()
                || people.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Passenger ID and number of people."
            );


            return;
        }


        crossingCounter++;


        String requestId =
                "CR" + crossingCounter;


        outputArea.setText(
                "Road Crossing Request Submitted!\n\n"
                        + "Request ID: " + requestId + "\n"
                        + "Passenger ID: " + passengerId + "\n"
                        + "Number of People: " + people + "\n\n"
                        + "Status: Pending Admin Approval"
        );
    }


    // =========================================================
    // VEHICLE METHODS
    // =========================================================

    private void addVehicle() {

        String name =
                vehNameField.getText().trim();


        String phone =
                vehPhoneField.getText().trim();


        String number =
                vehNumberField.getText().trim();


        String type =
                (String) vehTypeBox.getSelectedItem();


        if (name.isEmpty()
                || phone.isEmpty()
                || number.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all vehicle information."
            );


            return;
        }


        // Prevent duplicate registration

        if (registeredVehicles.contains(number)) {

            JOptionPane.showMessageDialog(
                    this,
                    "This vehicle is already registered."
            );


            return;
        }


        vehicleCounter++;


        registeredVehicles.add(number);


        outputArea.setText(
                "Vehicle Registered Successfully!\n\n"
                        + "Vehicle ID: V"
                        + vehicleCounter + "\n"
                        + "Owner: " + name + "\n"
                        + "Phone: " + phone + "\n"
                        + "Vehicle Number: " + number + "\n"
                        + "Vehicle Type: " + type + "\n\n"
                        + "This vehicle can now submit "
                        + "an emergency request when necessary."
        );
    }


    private void showPriorityList() {

        try {

            List<?> list =
                    controller.getPriorityList();


            outputArea.setText(
                    "Vehicle Priority List:\n\n"
                            + list.toString()
            );


        } catch (Exception e) {

            outputArea.setText(
                    "Priority list could not be displayed."
            );
        }
    }


    private void showTrafficRules() {

        outputArea.setText(
                "TRAFFIC RULES\n\n"
                        + "1. Emergency vehicles receive priority.\n"
                        + "2. Follow traffic signals.\n"
                        + "3. Do not block junctions.\n"
                        + "4. Follow police instructions.\n"
                        + "5. Keep emergency routes clear."
        );
    }


    // =========================================================
    // POLICE METHODS
    // =========================================================

    private void registerPolice() {

        String name =
                policeNameField.getText().trim();


        String phone =
                policePhoneField.getText().trim();


        String id =
                policeIdField.getText().trim();


        String location =
                policeLocationField.getText().trim();


        if (name.isEmpty()
                || phone.isEmpty()
                || id.isEmpty()
                || location.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all police information."
            );


            return;
        }


        outputArea.setText(
                "Police Officer Registered!\n\n"
                        + "Officer Name: " + name + "\n"
                        + "Phone: " + phone + "\n"
                        + "Police ID: " + id + "\n"
                        + "Location: " + location
        );
    }


    private void addJunction() {

        String id =
                junctionIdField.getText().trim();


        String location =
                junctionLocationField.getText().trim();


        if (id.isEmpty()
                || location.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter Junction ID and Location."
            );


            return;
        }


        outputArea.setText(
                "Junction Added Successfully!\n\n"
                        + "Junction ID: " + id + "\n"
                        + "Location: " + location
        );
    }


    private void requestClearance() {

        String junctionId =
                clearanceJunctionIdField.getText().trim();


        String officer =
                clearanceOfficerField.getText().trim();


        if (junctionId.isEmpty()
                || officer.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter Junction ID and Officer name."
            );


            return;
        }


        outputArea.setText(
                "Junction Clearance Request Submitted!\n\n"
                        + "Junction ID: " + junctionId + "\n"
                        + "Officer: " + officer + "\n\n"
                        + "Status: Pending Admin/Traffic Controller"
        );
    }


    // =========================================================
    // EMERGENCY REQUEST METHODS
    // =========================================================

    private void createEmergencyRequest() {

        String vehicleNumber =
                erVehicleNumberField.getText().trim();


        String location =
                erLocationField.getText().trim();


        String destination =
                erDestinationField.getText().trim();


        String reason =
                erReasonField.getText().trim();


        String emergencyPriority =
                (String) emergencyPriorityBox.getSelectedItem();


        // =====================================================
        // CHECK EMPTY FIELDS
        // =====================================================

        if (vehicleNumber.isEmpty()
                || location.isEmpty()
                || destination.isEmpty()
                || reason.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all emergency request information."
            );


            return;
        }


        // =====================================================
        // CHECK VEHICLE REGISTRATION
        // =====================================================

        if (!registeredVehicles.contains(vehicleNumber)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vehicle is not registered.\n\n"
                            + "Please register the vehicle first "
                            + "before creating an emergency request.",
                    "Vehicle Not Registered",
                    JOptionPane.WARNING_MESSAGE
            );


            return;
        }


        // =====================================================
        // CREATE REQUEST
        // =====================================================

        requestCounter++;


        String requestId =
                "ER" + requestCounter;


        outputArea.setText(
                "Emergency Request Created Successfully!\n\n"
                        + "Request ID: " + requestId + "\n"
                        + "Registered Vehicle: "
                        + vehicleNumber + "\n"
                        + "Current Location: "
                        + location + "\n"
                        + "Destination: "
                        + destination + "\n"
                        + "Emergency Reason: "
                        + reason + "\n"
                        + "Priority: "
                        + emergencyPriority + "\n\n"
                        + "Status: Pending Admin Approval"
        );
    }


    // =========================================================
    // ADMIN EMERGENCY ACTION
    // =========================================================

    private void handleEmergencyAction(String action) {

        String requestId =
                erRequestIdField.getText().trim();


        if (requestId.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter an Emergency Request ID."
            );


            return;
        }


        try {

            if (action.equals("APPROVE")) {

                controller.approveEmergency(requestId);


                outputArea.setText(
                        "Emergency Request "
                                + requestId
                                + " approved successfully."
                );


            } else if (action.equals("REJECT")) {

                controller.rejectEmergency(requestId);


                outputArea.setText(
                        "Emergency Request "
                                + requestId
                                + " rejected successfully."
                );


            } else if (action.equals("COMPLETE")) {

                controller.completeEmergency(requestId);


                outputArea.setText(
                        "Emergency Request "
                                + requestId
                                + " completed successfully."
                );
            }


        } catch (Exception e) {

            e.printStackTrace();


            JOptionPane.showMessageDialog(
                    this,
                    "Request " + requestId
                            + " could not be processed.\n\n"
                            + "Reason: "
                            + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =========================================================
    // ROADMAP METHODS
    // =========================================================

    private void addRoute() {

        String from =
                routeFromField.getText().trim();


        String to =
                routeToField.getText().trim();


        String distance =
                routeDistanceField.getText().trim();


        String density =
                (String) routeDensityBox.getSelectedItem();


        boolean blocked =
                routeBlockedBox.isSelected();


        if (from.isEmpty()
                || to.isEmpty()
                || distance.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all route information."
            );


            return;
        }


        outputArea.setText(
                "Route Added Successfully!\n\n"
                        + "From: " + from + "\n"
                        + "To: " + to + "\n"
                        + "Distance: " + distance + "\n"
                        + "Traffic Density: " + density + "\n"
                        + "Road Blocked: "
                        + (blocked ? "Yes" : "No")
        );
    }


    private void findRoute() {

        String source =
                routeSourceField.getText().trim();


        String destination =
                routeDestField.getText().trim();


        if (source.isEmpty()
                || destination.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter source and destination."
            );


            return;
        }


        outputArea.setText(
                "Route Search\n\n"
                        + "Source: " + source + "\n"
                        + "Destination: "
                        + destination + "\n\n"
                        + "Finding the best available route..."
        );
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new TrafficSystemGUI()
        );
    }
}