package Vista;

import Controlador.Controller;
import Controlador.ControllerView2;
import Model.ActorInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaP2 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private final ControllerView2 c;
    DefaultListModel<String> listActor;
    public VistaP2() {
        listActor = new DefaultListModel<>();
        initComponents();
        c = new ControllerView2();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaActores = new javax.swing.JList<>(listActor);
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        GenericName = new javax.swing.JTextField();
        RadioDeco = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        DarioEncrypt = new javax.swing.JRadioButton();
        RadioLambda = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        BtCreateActorGeneric = new javax.swing.JButton();
        BtCreateActor = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ActorNameText = new javax.swing.JTextField();
        RadioRing = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        RadioPingPong = new javax.swing.JRadioButton();
        RadioInsult = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Message = new javax.swing.JTextField();
        RadioMsg = new javax.swing.JRadioButton();
        RadioAddInsultMsg = new javax.swing.JRadioButton();
        RadioGetInsultMsg = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        RadioGetAllInsult = new javax.swing.JRadioButton();
        BtSendMsg = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        RadioPredicate = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(63, 229, 229));

        ListaActores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaActores);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Creador de actores genericos");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Lista de actores");

        jLabel1.setText("Nombre: ");

        buttonGroup1.add(RadioDeco);
        RadioDeco.setText("Decorator");
        RadioDeco.setActionCommand("Decorator");

        jLabel2.setText("Tipo de constructor");

        buttonGroup1.add(DarioEncrypt);
        DarioEncrypt.setSelected(true);
        DarioEncrypt.setText("Encrypt/Decrypt");
        DarioEncrypt.setActionCommand("Encrypt/Decrypt");

        buttonGroup1.add(RadioLambda);
        RadioLambda.setText("LambdaDeco");
        RadioLambda.setActionCommand("LambdaDeco");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        BtCreateActorGeneric.setText("Crear");
        BtCreateActorGeneric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    BtCreateActorGenericActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        BtCreateActor.setText("Crear");
        BtCreateActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    BtCreateActorActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Creador de actores");

        jLabel3.setText("Nombre: ");

        buttonGroup2.add(RadioRing);
        RadioRing.setText("RingActor");
        RadioRing.setActionCommand("RingActor");

        jLabel4.setText("Tipo de Actor");

        buttonGroup2.add(RadioPingPong);
        RadioPingPong.setSelected(true);
        RadioPingPong.setText("PingPong");
        RadioPingPong.setActionCommand("PingPong");

        buttonGroup2.add(RadioInsult);
        RadioInsult.setText("InsultActor");
        RadioInsult.setActionCommand("InsultActor");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Creador de mensajes");

        jLabel5.setText("Mensaje: ");

        buttonGroup3.add(RadioMsg);
        RadioMsg.setText("Message");
        RadioMsg.setActionCommand("Message");

        buttonGroup3.add(RadioAddInsultMsg);
        RadioAddInsultMsg.setText("AddInsultMessage");
        RadioAddInsultMsg.setActionCommand("AddInsultMessage");

        buttonGroup3.add(RadioGetInsultMsg);
        RadioGetInsultMsg.setText("GetInsultMessage");
        RadioGetInsultMsg.setActionCommand("GetInsultMessage");

        jLabel6.setText("Tipo de mensaje");

        buttonGroup3.add(RadioGetAllInsult);
        RadioGetAllInsult.setText("GetAllInsult");
        RadioGetAllInsult.setActionCommand("GetAllInsult");

        BtSendMsg.setText("Enviar");
        BtSendMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSendMsgActionPerformed(evt);
            }
        });

        jLabel7.setText("Tamaño del anillo");

        jTextField4.setText("0");

        buttonGroup3.add(RadioPredicate);
        RadioPredicate.setText("AddClosureMessage");
        RadioPredicate.setActionCommand("AddClosureMessage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 81, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(GenericName, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(RadioDeco)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(DarioEncrypt)
                                                                        .addComponent(RadioLambda)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(BtCreateActorGeneric)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(150, 150, 150)
                                                                .addComponent(BtCreateActor))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(65, 65, 65)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(ActorNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(RadioPingPong)
                                                                        .addComponent(RadioInsult)
                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(RadioRing)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel7)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(20, 20, 20)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(RadioPredicate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(BtSendMsg))
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(RadioMsg)
                                                        .addComponent(RadioAddInsultMsg)
                                                        .addComponent(RadioGetInsultMsg)
                                                        .addComponent(jLabel6)
                                                        .addComponent(RadioGetAllInsult))
                                                .addGap(36, 36, 36)))
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(276, 276, 276)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(592, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RadioMsg)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RadioAddInsultMsg)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RadioGetInsultMsg)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RadioGetAllInsult)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                                .addComponent(BtSendMsg)
                                                                .addGap(59, 59, 59))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(RadioPredicate)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(20, 20, 20)
                                                                                .addComponent(jLabel8)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(GenericName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(RadioDeco)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(DarioEncrypt)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(RadioLambda))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(22, 22, 22)
                                                                                .addComponent(jLabel10)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jLabel3)
                                                                                        .addComponent(ActorNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(RadioRing)
                                                                                        .addComponent(jLabel7)
                                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(RadioPingPong)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(RadioInsult)
                                                                                .addGap(35, 35, 35)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(BtCreateActor)
                                                                                        .addComponent(BtCreateActorGeneric))))
                                                                .addGap(0, 46, Short.MAX_VALUE))
                                                        .addComponent(jSeparator2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jSeparator3)
                                        .addGap(308, 308, 308)))
        );

        pack();
    }

    private void BtCreateActorGenericActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        if(buttonGroup1.getSelection() != null){
            listActor.addElement(c.crearActorGenerico(GenericName.getText(), buttonGroup1.getSelection().getActionCommand()));
            Thread.sleep(1000);
            String[] names = c.returnNames(listActor);
            ListaActores.setListData(names);
        }else System.out.println("Seleccione un radio button");
    }

    private void BtCreateActorActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        if(buttonGroup2.getSelection() != null){
            c.crearActor(ActorNameText.getText(), buttonGroup2.getSelection().getActionCommand(),Integer.valueOf(jTextField4.getText()),listActor);
            Thread.sleep(1000);
            String[] names = c.returnNames(listActor);
            ListaActores.setListData(names);
        }else System.out.println("Seleccione un radio button");
    }

    private void BtSendMsgActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Seleccione de la lista el actor que quiere recibir un mensaje");
        if(buttonGroup3.getSelection() != null && ListaActores.getSelectedValue() != null){
            String name = ListaActores.getSelectedValue().split(" ")[0];
            c.enviarMensaje(name, Message.getText(),buttonGroup3.getSelection().getActionCommand());
        }else System.out.println("Seleccione un radio button y seleccione un elemento de la lista");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaP2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField ActorNameText;
    private javax.swing.JButton BtCreateActor;
    private javax.swing.JButton BtCreateActorGeneric;
    private javax.swing.JButton BtSendMsg;
    private javax.swing.JRadioButton DarioEncrypt;
    private javax.swing.JTextField GenericName;
    private javax.swing.JList<String> ListaActores;
    private javax.swing.JTextField Message;
    private javax.swing.JRadioButton RadioAddInsultMsg;
    private javax.swing.JRadioButton RadioDeco;
    private javax.swing.JRadioButton RadioGetAllInsult;
    private javax.swing.JRadioButton RadioGetInsultMsg;
    private javax.swing.JRadioButton RadioInsult;
    private javax.swing.JRadioButton RadioLambda;
    private javax.swing.JRadioButton RadioMsg;
    private javax.swing.JRadioButton RadioPingPong;
    private javax.swing.JRadioButton RadioPredicate;
    private javax.swing.JRadioButton RadioRing;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration
}