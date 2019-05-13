package domain;


//@Configuration
public class CustomerDetails{
    private String setName;
    private String setSurName;
    private String setEmailAddress;
    private String setAddress;

    public CustomerDetails()
    {

    }//end default constructor
    private CustomerDetails(CustomerDetailsBuilder customerDetailsBuilder)
    {
        this.setName=customerDetailsBuilder.setName;
        this.setSurName=customerDetailsBuilder.setSurName;
        this.setEmailAddress=customerDetailsBuilder.setEmailAddress;
        this.setAddress=customerDetailsBuilder.setAddress;
    }//end parameterized constructor

    public String getSetName() {
        return setName;
    }

    public String getSetSurName() {
        return setSurName;
    }

    public String getSetEmailAddress() {
        return setEmailAddress;
    }

    public String getSetAddress() {
        return setAddress;
    }

    public static class CustomerDetailsBuilder
    {
        private String setName;
        private String setSurName;
        private String setEmailAddress;
        private String setAddress;



        public  CustomerDetailsBuilder setSetName(String setName) {
            this.setName = setName;
            return this;
        }



        public  CustomerDetailsBuilder setSetSurName(String setSurName) {
            this.setSurName = setSurName;
            return this;
        }


        public  CustomerDetailsBuilder setSetEmailAddress(String setEmailAddress) {
            this.setEmailAddress = setEmailAddress;
            return this;
        }



        public  CustomerDetailsBuilder setSetAddress(String setAddress) {
            this.setAddress = setAddress;
            return this;
        }
    public CustomerDetails customerDetailsBuilder()
    {
        return new CustomerDetails(this);
    }}//end CustomerDetailsBuildert

        @Override
        public String toString() {
            return "CustomerDetailsBuilder{" +
                    "setName='" + setName + '\'' +
                    ", setSurName='" + setSurName + '\'' +
                    ", setEmailAddress='" + setEmailAddress + '\'' +
                    ", setAddress='" + setAddress + '\'' +
                    '}';
        }

}//end CustomerDetails

