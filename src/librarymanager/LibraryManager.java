/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarymanager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class LibraryManager extends javax.swing.JFrame {

    // Tạo DefaultListModel để quản lý danh sách sách
    private DefaultListModel<String> bookListModel;
    private int totalBooks = 0;

    public LibraryManager() {
        initComponents();
        bookListModel = new DefaultListModel<>();
        bookList.setModel(bookListModel);

        // Thêm sự kiện cho nút "Thêm Sách"
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        // Thêm sự kiện cho nút "Xóa Sách"
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });

        // Thêm sự kiện cho nút "Mượn Sách"
        btnBorrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowBook();
            }
        });
    }

    private void addBook() {
        String title = txtTitle.getText().trim();
        String author = txtAuthor.getText().trim();

        if (!title.isEmpty() && !author.isEmpty()) {
            String bookEntry = title + " - " + author + " (Có sẵn)";
            bookListModel.addElement(bookEntry);
            totalBooks++;
            updateTotalBooks();
            txtTitle.setText("");
            txtAuthor.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteBook() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex != -1) {
            bookListModel.remove(selectedIndex);
            totalBooks--;
            updateTotalBooks();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách để xóa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void borrowBook() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedBook = bookListModel.getElementAt(selectedIndex);
            if (selectedBook.endsWith("(Có sẵn)")) {
                bookListModel.setElementAt(selectedBook.replace("(Có sẵn)", "(Đã mượn)"), selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Sách này đã được mượn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách để mượn!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateTotalBooks() {
        lblTotalBooks.setText("Tổng số sách hiện có: " + totalBooks);
    }

    // Hàm main để chạy ứng dụng
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryManager().setVisible(true);
            }
        });
    }

    // Đoạn code khởi tạo GUI do NetBeans tự động sinh ra
    @SuppressWarnings("unchecked")
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBorrow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookList = new javax.swing.JList<>();
        lblTotalBooks = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Thư Viện");

        lblTitle.setText("Tên Sách:");
        lblAuthor.setText("Tác Giả:");
        btnAdd.setText("Thêm Sách");
        btnDelete.setText("Xóa Sách");
        btnBorrow.setText("Mượn Sách");
        lblTotalBooks.setText("Tổng số sách hiện có: 0");

        jScrollPane1.setViewportView(bookList);

        // Layout của GUI
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitle)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblTotalBooks))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthor)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalBooks)
                .addContainerGap())
        );

        pack();
    }

    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnBorrow;
    private javax.swing.JList<String> bookList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalBooks;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtTitle;
}
