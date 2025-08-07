import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.*;

// Interface for sending notifications
interface Notifiable {
    void sendNotification(String message, LocalDateTime notifyTime);
}

// Interface for scheduling tasks
interface Schedulable {
    void schedule();
}

// Interface for tracking progress
interface Trackable {
    void trackProgress();
}

// Interface for storing and loading data
interface Storable {
    void save();

    void load();
}

// Interface for granting rewards
interface Rewardable {
    void grantReward();
}

// User class to store user details
class User {
    private String name;
    private String preference;

    public User(String name, String preference) {
        this.name = name;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}

// Student class, inheriting from User
class Student extends User {
    private List<Task> tasks;
    private Map<String, String> preferences; // Changed to private

    public Student(String name) {
        super(name, "Default"); // Calls the User constructor
        this.tasks = new ArrayList<>();
        this.preferences = new HashMap<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    // Method to customize preferences
    public void customizePreference(String key, String value) {
        this.preferences.put(key, value);
    }

    public Map<String, String> getPreferences() {
        return preferences;
    }
}

// Task class to represent a task, implements interfaces
class Task implements Schedulable, Trackable, Storable {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean completed;
    private String category; // Added category

    public Task(String title, String description, LocalDateTime dueDate, String category) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCategory() {
        return category;
    }

    public void editTask(String title, String description, LocalDateTime dueDate, String category) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
    }

    public void deleteTask() {
        // Implementation of deleteTask()
        System.out.println("Task '" + title + "' deleted.");
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public void schedule() {
        System.out.println("Task '" + title + "' scheduled for " + dueDate);
    }

    @Override
    public void trackProgress() {
        System.out.println("Progress of task '" + title + "': " + (completed ? "Completed" : "Incomplete"));
    }

    @Override
    public void save() {
        System.out.println("Task '" + title + "' saved.");
        //  save logic
    }

    @Override
    public void load() {
        System.out.println("Task '" + title + "' loaded.");
        //  load logic
    }
}

// Class to manage the list of tasks
class TaskManager {
    private List<Task> allTasks;
    private ReminderService reminders;

    public TaskManager() {
        this.allTasks = new ArrayList<>();
        this.reminders = new ReminderService();
    }

    public void addTask(Task task) {
        this.allTasks.add(task);
    }

    public void deleteTask(Task task) {
        this.allTasks.remove(task);
    }

    public void editTask(Task task, String newTitle, String newDescription, LocalDateTime newDueDate, String newCategory) {
        for (Task t : allTasks) {
            if (t.equals(task)) {
                t.editTask(newTitle, newDescription, newDueDate, newCategory);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void markTaskAsCompleted(Task task) {
        for (Task t : allTasks) {
            if (t.equals(task)) {
                t.markAsCompleted();
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public List<Task> filterTaskByCategory(String category) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : allTasks) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public List<Task> viewTaskBy(String category) {
        return filterTaskByCategory(category); // Corrected method call
    }

    public Task searchTask(String title) {
        for (Task task : allTasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> organizeTaskByDate() {
        List<Task> sortedTasks = new ArrayList<>(allTasks);
        Collections.sort(sortedTasks, Comparator.comparing(Task::getDueDate));
        return sortedTasks;
    }
}

// Class to manage reminders
class ReminderService {
    public List<Task> getUpcomingTasks(List<Task> tasks) {
        List<Task> upcomingTasks = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Task task : tasks) {
            if (task.getDueDate().isAfter(now)) {
                upcomingTasks.add(task);
            }
        }
        return upcomingTasks;
    }

    public List<Task> checkDueTasks(List<Task> tasks) {
        List<Task> dueTasks = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Task task : tasks) {
            if (task.getDueDate().isBefore(now)) {
                dueTasks.add(task);
            }
        }
        return dueTasks;
    }

    public void sendNotifications(List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getDueDate().isBefore(LocalDateTime.now())) {
                System.out.println("Notification: Task '" + task.getTitle() + "' is due!");
            }
        }
    }
}

// Class to handle notifications, implements Notifiable
class Notifications implements Notifiable {
    private String message;
    private LocalDateTime notifyTime;

    public Notifications(String message, LocalDateTime notifyTime) {
        this.message = message;
        this.notifyTime = notifyTime;
    }

    @Override
    public void sendNotification(String message, LocalDateTime notifyTime) {
        System.out.println("Sending notification: " + message + " at " + notifyTime);
        //  notification logic
    }
}

// Class to manage user's schedule
class ScheduleManager {
    private List<Task> tasks;

    public ScheduleManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public boolean exportSchedule(String filename) {
        System.out.println("Exporting schedule to " + filename);
        //  export logic
        return true;
    }

    public boolean importSchedule(String filename) {
        System.out.println("Importing schedule from " + filename);
        //  import logic
        return true;
    }

    public void viewCalendar(String viewType) {
        System.out.println("Viewing calendar: " + viewType);
        //  calendar view logic
    }
}

// Class to manage rewards
class Reward implements Rewardable, Storable {
    private int points;
    private boolean earned;

    public Reward() {
        this.points = 0;
        this.earned = false;
    }

    public int getPoints() {
        return points;
    }

    public boolean isEarned() {
        return earned;
    }

    @Override
    public void grantReward() {
        this.earned = true;
        System.out.println("Reward granted!");
    }

    public void trackProgress() {
        System.out.println("Current points: " + points);
    }

    @Override
    public void save() {
        System.out.println("Reward data saved.");
        //  save logic
    }

    @Override
    public void load() {
        System.out.println("Reward data loaded.");
        //  load logic
    }
}

// Class to represent levels
class Levels {
    private int levelNumber;

    public Levels() {
        this.levelNumber = 1;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}

// Class to represent badges
class Badge implements Storable {
    private String badgeName;
    private String description;

    public Badge(String badgeName, String description) {
        this.badgeName = badgeName;
        this.description = description;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void save() {
        System.out.println("Badge data saved.");
        //  save logic
    }

    @Override
    public void load() {
        System.out.println("Badge data loaded.");
        //  load logic
    }
}

// Class to manage points
class Points implements Storable {
    private int requiredPoints;
    private int currentPoints;

    public Points(int requiredPoints) {
        this.requiredPoints = requiredPoints;
        this.currentPoints = 0;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void addPoints(int points) {
        this.currentPoints += points;
    }

    public boolean checkSufficientPoints() {
        return currentPoints >= requiredPoints;
    }

    @Override
    public void save() {
        System.out.println("Points data saved.");
        //  save
    }

    @Override
    public void load() {
        System.out.println("Points data loaded.");
        //  load
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of classes
        Student student = new Student("Alice");
        Task task1 = new Task("Complete assignment", "Finish the Java assignment", LocalDateTime.of(2024, 12, 10, 18, 0), "Academics");
        Task task2 = new Task("Buy groceries", "Buy milk, eggs, and bread", LocalDateTime.of(2024, 12, 9, 10, 0), "Personal");
        Task task3 = new Task("Pay bills", "Pay rent and utilities", LocalDateTime.of(2024, 12, 11, 12, 0), "Personal");

        //Demonstrate adding and editing Prefs
        student.customizePreference("theme", "dark");
        student.customizePreference("notifications", "email");
        System.out.println("Student " + student.getName() + " preferences: " + student.getPreferences());

        // Add tasks to TaskManager
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        // Add tasks to student
        student.getTasks().add(task1);
        student.getTasks().add(task2);
        student.getTasks().add(task3);

        // Demonstrate task management
        System.out.println("\nAll Tasks:");
        for (Task task : taskManager.allTasks) {
            System.out.println(task.getTitle() + " - Due: " + task.getDueDate() + " - Category: " + task.getCategory());
        }

        taskManager.markTaskAsCompleted(task1);
        taskManager.editTask(task2, "Buy groceries", "Milk, eggs, bread, cheese", LocalDateTime.of(2024, 12, 9, 10, 0), "Personal");


        System.out.println("\nFiltered Tasks (Personal):");
        List<Task> personalTasks = taskManager.filterTaskByCategory("Personal");
        for (Task task : personalTasks) {
            System.out.println(task.getTitle() + " - Due: " + task.getDueDate());
        }

        System.out.println("\nSorted Tasks by Date:");
        List<Task> sortedTasks = taskManager.organizeTaskByDate();
        for (Task task : sortedTasks) {
            System.out.println(task.getTitle() + " - Due: " + task.getDueDate());
        }

        // Demonstrate Reminders
        System.out.println("\nUpcoming Tasks:");
        List<Task> upcomingTasks = taskManager.reminders.getUpcomingTasks(student.getTasks());
        for (Task task : upcomingTasks) {
            System.out.println(task.getTitle() + " - Due: " + task.getDueDate());
        }

        taskManager.reminders.sendNotifications(student.getTasks());

        //Demonstrate Reward System
        Reward reward = new Reward();
        reward.grantReward();
        reward.trackProgress();

        //Demonstrate Points System
        Points points = new Points(100);
        points.addPoints(50);
        System.out.println("Current Points: " + points.getCurrentPoints());
        System.out.println("Sufficient Points to claim reward: " + points.checkSufficientPoints());

        points.addPoints(50);
        System.out.println("Current Points: " + points.getCurrentPoints());
        System.out.println("Sufficient Points to claim reward: " + points.checkSufficientPoints());

        // Demonstrate Badges
        Badge badge1 = new Badge("Early Bird", "Completed a task before due date");
        Badge badge2 = new Badge("Night Owl", "Completed a task after due date");
        System.out.println("\nBadges:");
        System.out.println(badge1.getBadgeName() + ": " + badge1.getDescription());
        System.out.println(badge2.getBadgeName() + ": " + badge2.getDescription());

        // Demonstrate Levels
        Levels level = new Levels();
        System.out.println("\nCurrent level: " + level.getLevelNumber());
        level.setLevelNumber(2);
        System.out.println("Current level: " + level.getLevelNumber());

        //Demonstrate Schedule Manager
        ScheduleManager scheduleManager = new ScheduleManager();
        scheduleManager.addTask(task1);
        scheduleManager.addTask(task2);
        scheduleManager.addTask(task3);

        scheduleManager.exportSchedule("mySchedule.txt");
        scheduleManager.importSchedule("mySchedule.txt");
        scheduleManager.viewCalendar("monthly");
    }
}

// JUnit tests for the classes
class StudentTest {
    @Test
    void testCustomizePreference() {
        Student student = new Student("Bob");
        student.customizePreference("theme", "light");
        assertEquals("light", student.getPreferences().get("theme"));
    }

    @Test
    void testGetTasks() {
        Student student = new Student("Charlie");
        Task task1 = new Task("Study", "Read chapter 5", LocalDateTime.now(), "Academics");
        student.getTasks().add(task1);
        assertEquals(1, student.getTasks().size());
        assertTrue(student.getTasks().contains(task1));
    }
}

class TaskTest {
    @Test
    void testEditTask() {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task("Original Title", "Original Description", now, "Original Category");
        task.editTask("New Title", "New Description", now.plusDays(1), "New Category");
        assertEquals("New Title", task.getTitle());
        assertEquals("New Description", task.getDescription());
        assertEquals(now.plusDays(1), task.getDueDate());
        assertEquals("New Category", task.getCategory());
    }

    @Test
    void testMarkAsCompleted() {
        Task task = new Task("Task", "Description", LocalDateTime.now(), "Category");
        assertFalse(task.isCompleted());
        task.markAsCompleted();
        assertTrue(task.isCompleted());
    }
}

class TaskManagerTest {
    @Test
    void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task1", "Description", LocalDateTime.now(), "Category");
        taskManager.addTask(task);
        assertEquals(1, taskManager.allTasks.size());
        assertTrue(taskManager.allTasks.contains(task));
    }

    @Test
    void testDeleteTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task2", "Description", LocalDateTime.now(), "Category");
        taskManager.addTask(task);
        taskManager.deleteTask(task);
        assertEquals(0, taskManager.allTasks.size());
        assertFalse(taskManager.allTasks.contains(task));
    }

    @Test
    void testEditTask() {
        TaskManager taskManager = new TaskManager();
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task("Old Title", "Old Description", now, "Old Category");
        taskManager.addTask(task);
        taskManager.editTask(task, "New Title", "New Description", now.plusDays(1), "New Category");
        Task editedTask = taskManager.searchTask("New Title");
        assertNotNull(editedTask);
        assertEquals("New Description", editedTask.getDescription());
        assertEquals(now.plusDays(1), editedTask.getDueDate());
        assertEquals("New Category", editedTask.getCategory());
    }

    @Test
    void testMarkTaskAsCompleted() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task3", "Description", LocalDateTime.now(), "Category");
        taskManager.addTask(task);
        taskManager.markTaskAsCompleted(task);
        Task completedTask = taskManager.searchTask("Task3");
        assertTrue(completedTask.isCompleted());
    }

    @Test
    void testFilterTaskByCategory() {
        TaskManager taskManager = new TaskManager();
        LocalDateTime now = LocalDateTime.now();
        Task task1 = new Task("Task1", "Description", now, "Personal");
        Task task2 = new Task("Task2", "Description", now.plusDays(1), "Work");
        Task task3 = new Task("Task3", "Description", now.plusDays(2), "Personal");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        List<Task> personalTasks = taskManager.filterTaskByCategory("Personal");
        assertEquals(2, personalTasks.size());
        assertTrue(personalTasks.contains(task1));
        assertTrue(personalTasks.contains(task3));
        assertFalse(personalTasks.contains(task2));
    }

    @Test
    void testViewTaskByCategory() {
        TaskManager taskManager = new TaskManager();
        LocalDateTime now = LocalDateTime.now();
        Task task1 = new Task("Task1", "Description", now, "Personal");
        Task task2 = new Task("Task2", "Description", now.plusDays(1), "Work");
        Task task3 = new Task("Task3", "Description", now.plusDays(2), "Personal");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        List<Task> personalTasks = taskManager.viewTaskBy("Personal");
        assertEquals(2, personalTasks.size());
        assertTrue(personalTasks.contains(task1));
        assertTrue(personalTasks.contains(task3));
        assertFalse(personalTasks.contains(task2));
    }

    @Test
    void testSearchTask() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Task1", "Description", LocalDateTime.now(), "Category");
        Task task2 = new Task("Task2", "Description", LocalDateTime.now().plusDays(1), "Category");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        Task foundTask1 = taskManager.searchTask("Task1");
        Task foundTask2 = taskManager.searchTask("Task2");
        Task notFoundTask = taskManager.searchTask("Task3");
        assertEquals(task1, foundTask1);
        assertEquals(task2, foundTask2);
        assertNull(notFoundTask);
    }

    @Test
    void testOrganizeTaskByDate() {
        TaskManager taskManager = new TaskManager();
        LocalDateTime now = LocalDateTime.now();
        Task task1 = new Task("Task1", "Description", now.plusDays(2), "Category");
        Task task2 = new Task("Task2", "Description", now, "Category");
        Task task3 = new Task("Task3", "Description", now.plusDays(1), "Category");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        List<Task> sortedTasks = taskManager.organizeTaskByDate();
        assertEquals(3, sortedTasks.size());
        assertEquals(task2, sortedTasks.get(0));
        assertEquals(task3, sortedTasks.get(1));
        assertEquals(task1, sortedTasks.get(2));
    }
}

class ReminderServiceTest {
    @Test
    void testGetUpcomingTasks() {
        ReminderService reminderService = new ReminderService();
        LocalDateTime now = LocalDateTime.now();
        Task task1 = new Task("Task1", "Description", now.plusDays(1), "Category");
        Task task2 = new Task("Task2", "Description", now.minusDays(1), "Category");
        Task task3 = new Task("Task3", "Description", now.plusDays(2), "Category");
        List<Task> tasks = Arrays.asList(task1, task2, task3);
        List<Task> upcomingTasks = reminderService.getUpcomingTasks(tasks);
        assertEquals(2, upcomingTasks.size());
        assertTrue(upcomingTasks.contains(task1));
        assertTrue(upcomingTasks.contains(task3));
        assertFalse(upcomingTasks.contains(task2));
    }

    @Test
    void testCheckDueTasks() {
        ReminderService reminderService = new ReminderService();
        LocalDateTime now = LocalDateTime.now();
        Task task1 = new Task("Task1", "Description", now.plusDays(1), "Category");
        Task task2 = new Task("Task2", "Description", now.minusDays(1), "Category");
        Task task3 = new Task("Task3", "Description", now.plusDays(2), "Category");
        List<Task> tasks = Arrays.asList(task1, task2, task3);
        List<Task> dueTasks = reminderService.checkDueTasks(tasks);
        assertEquals(1, dueTasks.size());
        assertTrue(dueTasks.contains(task2));
        assertFalse(dueTasks.contains(task1));
        assertFalse(dueTasks.contains(task3));
    }
}

class NotificationsTest {
    //  Add tests for Notifications class if needed.  The current implementation simply prints to the console,
    //  which is difficult to test automatically.  If you change the implementation to use a logging framework
    //  or some other mechanism, you can add tests here.
}

class ScheduleManagerTest {
    //  Add tests for ScheduleManager.  The current implementation simply prints to the console and returns a boolean,
    //  which is difficult to test automatically.  If you change the implementation to use a file system
    //  or some other mechanism, you can add tests here.
}

class RewardTest {
    @Test
    void testGrantReward() {
        Reward reward = new Reward();
        assertFalse(reward.isEarned());
        reward.grantReward();
        assertTrue(reward.isEarned());
    }
    @Test
    void testGetPoints(){
        Reward reward = new Reward();
        assertEquals(0, reward.getPoints());
    }
}

class LevelsTest {
    @Test
    void testSetLevelNumber() {
        Levels levels = new Levels();
        assertEquals(1, levels.getLevelNumber());
        levels.setLevelNumber(5);
        assertEquals(5, levels.getLevelNumber());
    }
}

class BadgeTest {
    //Add tests for Badge.  The current implementation simply prints to the console,
    //which is difficult to test automatically.
}

class PointsTest{
    @Test
    void testAddPoints(){
        Points points = new Points(100);
        points.addPoints(50);
        assertEquals(50, points.getCurrentPoints());
        points.addPoints(30);
        assertEquals(80, points.getCurrentPoints());
    }

    @Test
    void testCheckSufficientPoints