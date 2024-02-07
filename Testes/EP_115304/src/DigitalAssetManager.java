
import java.util.*;

public class DigitalAssetManager implements DigitalAssetManagerInterface{
    private Set<DigitalObject> listaObjetos = new HashSet<>();
    private Set<User> listaUtilizadores = new HashSet<>();

    private Map<DigitalObject,Set<RegisteredUser>> mapPartilhas = new HashMap<>();

    @Override
    public User registerUser(String userName) {


        if(getUser(userName) == null){
            User user = new RegisteredUser(userName);
            listaUtilizadores.add(user);
            return user;
        }
        System.out.println("That username already exists.");
        return null;
    }

    @Override
    public User getUser(String userName) {
        return listaUtilizadores.stream().filter(user -> user.getNome().equals(userName)).findFirst().orElse(null);
    }

    public DigitalObject getObject(String doi) {
        return listaObjetos.stream().filter(user -> user.getDoi().equals(doi)).findFirst().orElse(null);
    }

    @Override
    public User createGuestUser() {
        String userName = "";
        do{
            userName = DigitalAssetManagerInterface.generateFakeName();
        }while ( getUser(userName) != null);

        User user = new GuestUser(userName);
        listaUtilizadores.add(user);
        return user;

    }

    @Override
    public DigitalObject registerDigitalObject(String doi, User owner) {
        if(getUser(owner.getNome()) == owner && owner.getType().equals(UserType.REGISTERED)){
            DigitalObject digitalObject = new DigitalObject(doi);
            digitalObject.setOwner(owner);
            listaObjetos.add(digitalObject);
            Set<RegisteredUser> registeredUsers = new HashSet<>();
            registeredUsers.add((RegisteredUser) owner);
            mapPartilhas.put(digitalObject, registeredUsers);
            return digitalObject;
        }
        return null;
    }

    @Override
    public DigitalObject registerDigitalObject(String doi, SensitivityLevel sensitivityLevel, User owner) {
        if(owner != null && getUser(owner.getNome()) == owner && owner.getType().equals(UserType.REGISTERED)){
            DigitalObject digitalObject = new DigitalObject(doi,sensitivityLevel);
            digitalObject.setOwner(owner);
            listaObjetos.add(digitalObject);
            Set<RegisteredUser> registeredUsers = new HashSet<>();
            registeredUsers.add((RegisteredUser) owner);
            mapPartilhas.put(digitalObject, registeredUsers);
            return digitalObject;
        }
        return null;
    }

    @Override
    public List<String> listRegisteredUsers() {
        return listaUtilizadores.stream()
                .filter(user -> user.getType().equals(UserType.REGISTERED))
                .map(User::toString)
                .toList();
    }

    @Override
    public List<String> listUserObjects(User u) {
        return listaObjetos.stream()
                .filter(object -> object.getOwner().equals(u))
                .map(Object::toString)
                .toList();
    }

    @Override
    public boolean setObjectSensitivity(String doi, SensitivityLevel sensitivityLevel, User owner) {
        DigitalObject object = getObject(doi);
        if(object != null && object.getOwner().equals(owner)){
            object.setSensitivityLevel(sensitivityLevel);
            return true;
        }
        System.out.println("User does not own the digital object.");
        return false;
    }

    @Override
    public boolean setPublic(String doi, User owner) {
        DigitalObject object = getObject(doi);
        if(object != null &&
                object.getOwner().equals(owner) &&
                object.getSensitivityLevel().equals(SensitivityLevel.LOW)){
            object.setPartilha(true);
            return true;
        }
        System.out.println("Only digital objects with sensibility level LOW can be made public.");
        return false;
    }

    @Override
    public boolean shareObject(String doi, User owner, User otherUser) {
        DigitalObject digitalObject = getObject(doi);
        if(digitalObject.getSensitivityLevel().equals(SensitivityLevel.PERSONAL)){
            System.out.println("Digital objects with sensiblity level PERSONAL cannot be shared.");
            return false;
        }
        if(digitalObject.getOwner().equals(owner) &&
                (digitalObject.getSensitivityLevel().equals(SensitivityLevel.RESTRICTED) || digitalObject.getSensitivityLevel().equals(SensitivityLevel.LOW)) &&
                otherUser.getType().equals(UserType.REGISTERED)){
            mapPartilhas.get(digitalObject).add((RegisteredUser) otherUser);
            return true;
        }
        return false;
    }

    @Override
    public DigitalObject getObject(String doi, User user) {
        // guest users can not access non-public objects
        DigitalObject digitalObject = getObject(doi);

        if(!digitalObject.isPartilha() && user.getType().equals(UserType.GUEST)){
            System.out.println("Guest users can only access public digital objects.");
            return null;
        }

        if(!mapPartilhas.get(digitalObject).contains(user) && user.getType().equals(UserType.REGISTERED)){
            return null;
        }

        return digitalObject;
    }

    public Set<RegisteredUser> listUsersWithObjectAccess(String doi) {
        DigitalObject digitalObject = getObject(doi);
        User owner = digitalObject.getOwner();
        return mapPartilhas.get(digitalObject);
    }

    public Set<DigitalObject> listObjectSharedWithUser(User user) {
        Set<DigitalObject> setRet = new HashSet<>();

        for(Map.Entry<DigitalObject,Set<RegisteredUser>> entry: mapPartilhas.entrySet()){
            DigitalObject digitalObject = entry.getKey();
            entry.getValue().forEach(registeredUser -> {
                // Faltava meter no if (!digitalObject.getOwner().equals(registeredUser) && ...) ps: és mesmo burro!
                if( registeredUser.equals(user)){
                    setRet.add(digitalObject);
                }
            });
        }
        return setRet;
    }
}
