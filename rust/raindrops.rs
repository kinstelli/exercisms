pub fn raindrops(n: u32) -> String {
    let mut droplet: String = String::new();
    if n % 3 == 0 {
        droplet += "Pling";
    }
    if n % 5 == 0 {
        droplet += "Plang";
    }
    if n % 7 == 0 {
        droplet += "Plong";
    }
    if droplet.is_empty() {
        return format!("{}", n.to_string());
    }
    droplet
}
