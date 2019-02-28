package groupproject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {
    Scanner reader = new Scanner(System.in);
    private String name;
    private String projectLeader;
    String description;
    int x;
    public List<Project> pList =new ArrayList<Project>();
    public List<Members> mList;
    public List<Risks> rList;
    public ArrayList<String> funReq;
    public ArrayList<String> nonReq;
    public Project(String name, String projectLeader, String description)
    {
        funReq = new ArrayList<String>();
        nonReq = new ArrayList<String>();
        mList = new ArrayList<Members>();
        this.rList = new ArrayList<Risks>();
        this.name = name;
        this.projectLeader = projectLeader;
        this.description = description;
    }
    Project()
    {
        
    }
    void printMenu()
    {
        System.out.println("Press 1 and enter to create a new project.");
        System.out.println("Press 2 and then enter to view all projects by name and index.");
        System.out.println("Press 3 and enter to view a project's attriutes.");
        System.out.println("Press 4 to add team members to a specific project.");
        System.out.println("Press 5 to add Functional Requirements and Non-Functional Requirements to a specific project.");
    }
    public Members createMember(String memberName)
    {
        return new Members(memberName);
    }
    public Risks createRisks(String riskName)
    {
        return new Risks(riskName);
    }
    public Project createProject(String name, String projectLeader, String description)
    {
        this.description = description;
        this.name = name;
        this.projectLeader = projectLeader;
        return new Project(name, projectLeader, description);
    }
    String displayName()
    {
        return name;
    }
    String displayLeader()
    {
        return projectLeader;
    }
    String displayDescription()
    {
        return description;
    }
    void displayFunReq()
    {
        for(int i = 0; i < funReq.size(); i++) 
        {
            System.out.println(funReq.get(i));
        }
    }
    void displayNonReq()
    {
        for(int i = 0; i < nonReq.size(); i++) 
        {
            System.out.println(nonReq.get(i));
        }
    }
    void menuSwitch()
    {
        int x = reader.nextInt();
         switch (x) 
         {
            case 1: System.out.println("Please enter the name of the new project you would like to add.");
                    String name = reader.next();
                    
                        for(int i = 0; i < pList.size(); i++)
                        {                  
                           while(pList.get(i).displayName().contains(name))
                           {
                               System.out.println("This project name already exists. Try again: ");  
                               name = reader.next();
                           }   
                        }
                                
                    System.out.println("Please enter the name of the project leader.");
                    String projectLeader = reader.next();
                    
                    System.out.println("Please enter the description for the project.");
                    String description = reader.next(); 
                    pList.add(createProject(name, projectLeader, description));
                    break;
                                     
            case 2: for(int i = 0; i < pList.size(); i++)
                {
                    System.out.println("Project " + i + "'s project name is " + pList.get(i).displayName() + ", the leader is " + pList.get(i).displayLeader() + ". "
                    );      
                }
                    break;
            case 3: System.out.println("Please enter the index of the project to view its attributes...");
                    int index1 = reader.nextInt();
                    System.out.println("Project " + index1 + "'s project name is " + pList.get(index1).displayName() + ", the leader is " + pList.get(index1).displayLeader() + ", it's description is " + pList.get(index1).displayDescription() + ". "
                    );
                    System.out.println("Project " + pList.get(index1).displayName()+ " has ");
                    if(pList.get(index1).mList.size() == 0)
                    {
                        System.out.println("no current team members.");
                    }
                    else
                    {
                        System.out.print(pList.get(index1).mList.size() + " team members and they are...");
                        for(int i = 0; i < pList.get(index1).mList.size(); i++)
                        System.out.println(pList.get(index1).mList.get(i).name);
                    }
                    if(pList.get(index1).rList.size() == 0)
                    {
                        System.out.println("No current risks associtated with project.");
                    }
                    else
                    {
                        System.out.print(pList.get(index1).rList.size() + " team members and they are...");
                        for(int i = 0; i < pList.get(index1).rList.size(); i++)
                        System.out.println(pList.get(index1).rList.get(i).name);
                    }
                    System.out.println("The Functional Requirements are: ");
                    pList.get(index1).displayFunReq(); //print functional req
                    
                    System.out.println("The Non-Functional Requirements are: ");
                    pList.get(index1).displayNonReq(); //print nonfunctional req
                    
                    break;
            case 4: System.out.println("Please enter the project index..");
                    int index2 = reader.nextInt();
                    
                    System.out.println("Press '1' to add a team member and '2' to remove a team member: ");
                    int choice = reader.nextInt();
                    
                    if(choice == 1){
                    System.out.println("Please enter the name of team member to add to the project at index " + index2 + ".");
                    String memberName = reader.next();
                    pList.get(index2).mList.add(createMember(memberName));
                    }
                    
                    if(choice == 2){
                    System.out.println("Please enter the name of team member to remove from the project at index " + index2 + ".");
                    
                    String memberName = reader.next();
                    
                    for(int i = 0; i < pList.get(index2).mList.size(); i++)
                    {
                        if(pList.get(index2).mList.get(i).name == memberName);
                        
                        pList.get(index2).mList.remove(pList.get(index2).mList.get(i));
                    }
                    }
            case 5: System.out.println("Please enter the project index..");
                    int index3 = reader.nextInt();
                    
                    String functionalRequirements;
                    String nonFunctionalRequirements;
               
                    System.out.println("Please enter the Functional Requirements. Press Enter between inputs. Type 'Quit' to exit: "); 
                    while(true) {
                        functionalRequirements = reader.next();
                        if(functionalRequirements.equals("quit"))
                        {
                            break;
                        }
                        pList.get(index3).funReq.add(functionalRequirements);
                    }
                    
                    
                    System.out.println("Please enter the Non-Functional Requirements. Press Enter between inputs. Type 'Quit' to exit: "); 
                    while(true) {
                        nonFunctionalRequirements = reader.next();
                        if(nonFunctionalRequirements.equals("quit"))
                        {
                            break;
                        }
                        pList.get(index3).nonReq.add(nonFunctionalRequirements);
                    }
                    
                    break;
            case 6: System.out.println("Please enter the project index.....");
                    index3 = reader.nextInt();
                    String riskName;
                    System.out.println("Please enter the risk to add to the project. Press enter between inputs. Type 'quit' to exit: ");
                    while(true)
                    {
                        riskName = reader.next();
                        if(riskName.equals("quit"))
                        {
                            break;
                        }
                        pList.get(index3).rList.add(createRisks(riskName));
                    }
                    break;
            default: break;
         }
         continueLoop();
    }  
    void continueLoop()
    {
        System.out.println("Would you like to continue or end session? Yes to continue or no to end");
        String response = reader.next();
        if(response.equals("yes"))
        {
            printMenu();
            menuSwitch();
        }
        if(response == "no")
        {
            System.out.print("End of test");
        }
        if(response != "yes" || response != "no")
        {
            System.out.print("Invalid Response \n");
            continueLoop();
        }
    }
}
