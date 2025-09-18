# 📚 StudyMile - Personal Study Management System

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![OOP](https://img.shields.io/badge/OOP-Object--Oriented-4CAF50?style=for-the-badge)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

> A comprehensive Java-based console application designed to help students manage their academic journey effectively. StudyMile serves as a personal study companion that assists students in organizing courses, tracking progress, calculating GPAs, and generating personalized study plans.

## 🌟 Features

### 📋 **Core Functionality**
- **👤 User Profile Management** - Complete registration and profile system
- **📚 Course Management** - Add, update, and track academic subjects
- **📊 GPA Calculator** - Support for both 4.0 and 5.0 scale systems
- **📅 Study Plan Generator** - Personalized study schedules based on performance
- **📈 Progress Tracking** - Monitor grades and study hours
- **✅ To-Do List Management** - Organize and track daily tasks

### 🎯 **Key Highlights**
- **🎨 Color-coded Interface** - Beautiful console UI with visual feedback
- **🔒 Input Validation** - Comprehensive data validation and error handling
- **💾 Data Persistence** - Automatic file-based data storage
- **⚡ Real-time Calculations** - Instant GPA and progress calculations
- **🎯 Performance-based Planning** - Smart study hour allocation

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Any operating system (Windows, macOS, Linux)

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/studymile.git
   cd studymile
   ```

2. **Compile the application**
   ```bash
   javac *.java
   ```

3. **Run the application**
   ```bash
   java Main
   ```

### First Time Setup
1. Register your profile with personal information
2. Add your subjects with grades and credit hours
3. Generate your personalized study plan
4. Start tracking your academic progress!

## 📖 Usage Guide

### 1. **Profile Management**
```
Create a username: yourname
Enter your age: 20
Enter gender: male/female
Enter your phone number: 12345678901
Enter your major: Computer Science
Enter semester: 3
```

### 2. **Course Management**
- Add subjects with names, grades, and credit hours
- Update existing courses
- Track grade improvements over time

### 3. **GPA Calculation**
- Choose between 4.0 or 5.0 scale
- Enter final grades for each subject
- Get instant GPA calculation with detailed breakdown

### 4. **Study Planning**
- Enter available study hours per week
- Get personalized study plan based on:
  - Subject difficulty levels
  - Credit hours
  - Performance history

### 5. **Progress Tracking**
- Monitor study hours vs. planned hours
- Track grade improvements
- View completion percentages

## 🏗️ Architecture

### **Class Diagram**
```
User (Abstract)
└── Student (Concrete)

Supporting Classes:
├── Subject (Data Model)
├── FileOperations (Persistence)
├── GpaCalculator (Calculations)
├── Progress (Tracking)
├── ToDoList (Task Management)
├── Plane (Study Planning)
├── InputValidator (Validation)
└── Constants (Configuration)
```

### **Design Patterns**
- **Abstract Class Pattern** - User hierarchy
- **Interface Pattern** - GPA calculation strategies
- **Composition Pattern** - Feature combination
- **File-based Persistence** - Data storage

## 📁 Project Structure

```
StudyMile/
├── Main.java                 # Application entry point
├── User.java                 # Abstract base class
├── Student.java              # Main business logic
├── Subject.java              # Data model for courses
├── FileOperations.java       # File I/O operations
├── GpaCalculator.java        # GPA calculation logic
├── Progress.java             # Progress tracking
├── ToDoList.java             # Task management
├── Plane.java                # Study plan generator
├── GpaCalc.java              # GPA calculation interface
├── InputValidator.java       # Input validation utilities
├── Constants.java            # Application constants
└── README.md                 # This file
```

## 🎮 Menu System

### **Main Menu**
1. **My Profile** - View and update personal information
2. **Update Courses** - Manage academic subjects
3. **Grade Tracker** - Monitor and update grades
4. **GPA Calculator** - Calculate academic performance
5. **Plan Generator** - Create study schedules
6. **To-Do List** - Manage daily tasks
7. **Exit** - Close application

### **Sub-menus**
Each main option contains detailed sub-menus for specific functionality, providing an intuitive and organized user experience.

## 🔧 Technical Details

### **Input Validation**
- Age: 16-50 years
- Phone: Exactly 11 digits
- Gender: Male/Female only
- Grades: 0-100% range
- Credit Hours: 2 or 3 credits

### **Data Storage**
- Tab-separated value files
- Automatic file creation
- Cross-session persistence
- Data integrity validation

### **Error Handling**
- Comprehensive try-catch blocks
- User-friendly error messages
- Input validation with retry prompts
- Graceful error recovery

## 🎯 Educational Value

This project demonstrates:
- **Object-Oriented Programming** principles
- **Inheritance and Polymorphism**
- **File I/O Operations**
- **Input Validation**
- **User Interface Design**
- **Data Structure Management**
- **Algorithm Implementation**
- **Software Engineering Best Practices**

## 🚀 Future Enhancements

- [ ] Database integration
- [ ] Graphical User Interface (GUI)
- [ ] Multi-user support
- [ ] Cloud synchronization
- [ ] Mobile application
- [ ] Advanced analytics
- [ ] Calendar integration
- [ ] Export/Import functionality

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### **How to Contribute**
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)
- Email: your.email@example.com

## 🙏 Acknowledgments

- Java community for excellent documentation
- Object-Oriented Programming concepts
- All contributors and testers

## 📊 Project Stats

![GitHub stars](https://img.shields.io/github/stars/yourusername/studymile?style=social)
![GitHub forks](https://img.shields.io/github/forks/yourusername/studymile?style=social)
![GitHub issues](https://img.shields.io/github/issues/yourusername/studymile)
![GitHub pull requests](https://img.shields.io/github/issues-pr/yourusername/studymile)

---

<div align="center">

**⭐ If you found this project helpful, please give it a star! ⭐**

Made with ❤️ for students and developers

</div>
