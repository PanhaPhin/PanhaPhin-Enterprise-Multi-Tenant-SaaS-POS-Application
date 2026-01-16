import { useState } from "react";
import { ShoppingCart } from "lucide-react";
import { Label } from "@radix-ui/react-label";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { Checkbox } from "@/components/ui/checkbox";
import { Separator } from "@/components/ui/separator";

const Login = () => {
    const [forgotPasswordEmail,setForgotPasswordEmail]=useState("")


  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const [showForgotPassword, setShowForgotPassword] = useState(false);

  const handleLogin = (e) => {
    e.preventDefault();
    console.log("Login submitted", formData);
  };



  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleForgotPassword=()=>{
    console.log("forgot password email", forgotPasswordEmail)
  }

  

  return (
    <div
      className="min-h-screen bg-linear-to-br from-primary/5 to-primary/10
      flex items-center justify-center p-4 relative"
    >
      <div className="w-full max-w-md">
        <div className="text-center mb-8">
          <div className="flex items-center justify-center space-x-2 mb-4">
            <div className="w-10 h-10 bg-primary rounded-lg flex items-center justify-center">
              <ShoppingCart className="w-6 h-6 text-primary-foreground" />
            </div>

            <span className="text-2xl font-bold text-foreground">Pos Pro</span>
          </div>

          <h1
            className={showForgotPassword ? "text-red-500" : "text-foreground"}
          >
            {showForgotPassword ? "Forgot Password" : "Welcome Back!"}
          </h1>

          <p className="text-muted-foreground mt-2">
            {showForgotPassword
              ? "Enter your email to reset your password"
              : "Please enter your credentials to login"}
          </p>
        </div>

        {!showForgotPassword && (
          <div className="bg-card rounded-2xl shadow-xl p-8">
            <form className="space-y-4" onSubmit={handleLogin}>
              <div className="space-y-3">
                <Label htmlFor="email">Email Address</Label>
                <Input
                  id="email"
                  name="email"
                  type="email"
                  placeholder="Enter your email"
                  value={formData.email}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="space-y-3">
                <Label htmlFor="password">Password</Label>
                <Input
                  id="password"
                  name="password"
                  type="password"
                  placeholder="Enter your password"
                  value={formData.password}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="flex items-center justify-between">
                <div className="flex items-center gap-3">
                  <Checkbox
                    name="remember"
                    type={"checkbox"}
                    className={
                      "h-4 w-4 text-primary focus:ring-primary border-gray-300 "
                    }
                  />

                  <Label>Remember me</Label>
                </div>

                <Button
                  onClick={() => setShowForgotPassword(true)}
                  variant={"ghost"}
                >
                  Forget Password?
                </Button>
              </div>

              <Button className="py-4 w-full" type="submit">
                Login
              </Button>
            </form>

            <Separator />

            <div className="mt-6 p-4 bg-muted rounded-lg">
              <p className="text-sm text-muted-foreground text-center">
                <strong>Demo Account</strong>
                <br />
                Email: panha124@gmail.com <br />
                Password: Panha124@ <br />
              </p>
            </div>
          </div>
        )}

        {showForgotPassword && (
          <div className="bg-card rounded-2xl shadow-xl p-8">
            <form className="space-y-4" onSubmit={handleForgotPassword}>
              <div className="space-y-3">
                <Label htmlFor="email">Email Address</Label>
                <Input
                  id="email"
                  name="forgotPasswordEmail"
                  type="email"
                  placeholder="Enter your email.."
                  value={forgotPasswordEmail}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="flex items-center justify-between">
                <Button
                  variant={"outline"}
                  onClick={() => setShowForgotPassword(false)}
                  className="py-4 "
                >
                  Back to login
                </Button>

                <Button className="py-4 " type="submit">
                  Sent Reset Link
                </Button>
              </div>
            </form>
          </div>
        )}
      </div>
    </div>
  );
};

export default Login;
