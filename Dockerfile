FROM maven:3.9.15-eclipse-temurin-21

# Linux dependencies aur stable Google Chrome install karna
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    ca-certificates \
    apt-transport-https \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list' \
    && apt-get update && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Working directory set karna
WORKDIR /app

# Poora code container me copy karna
COPY . .

# Dependencies download aur install karna (Tests skip karke sirf build)
RUN mvn clean install -DskipTests

# Container run hote hi test suite run hoga
CMD ["mvn", "test"]